package com.yuliang.tutorial.basic.concurrent.timeout;


import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class TimeOutNoDeadLock{
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        List<Thread> threadAS = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<100;i++) {
            list.add(i);
        }

        for(int i=0;i<100;i++) {
            Thread threadA = new Thread(new ThreadA(list, stack, lock1, lock2));
            threadA.start();
            threadAS.add(threadA);
            Thread threadB = new Thread(new ThreadB(list, stack, lock1, lock2));
            threadB.start();
            threadAS.add(threadB);
        }

        for (Thread threadA : threadAS) {
            try {
                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(stack.size());
    }

}

class ThreadA implements Runnable {
    private List<Integer> list;
    private Stack<Integer> stack;
    private ReentrantLock lock1;
    private ReentrantLock lock2;

    public ThreadA(List<Integer> list, Stack<Integer> stack, ReentrantLock lock1, ReentrantLock lock2) {
        this.list = list;
        this.stack = stack;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        boolean isDone = false;

        while(!isDone) {
            boolean firstLockRequired = false;
            boolean secondLockRequired = false;
            try {
                firstLockRequired = lock1.tryLock(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "acquires the second lock.");

            try {
                secondLockRequired = lock2.tryLock(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(firstLockRequired && secondLockRequired) {
                if(!list.isEmpty()) {
                    Integer integer = list.remove(list.size() - 1);
                    stack.push(integer);
                }
                isDone = true;
                lock1.unlock();
                lock2.unlock();
            } else {
                if(firstLockRequired) {
                    lock1.unlock();
                    System.out.println("ThreadA releases lock1");
                    try {
                        Thread.sleep(new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(secondLockRequired) {
                    lock2.unlock();
                    System.out.println("ThreadA releases lock2");
                    try {
                        Thread.sleep(new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class ThreadB implements Runnable {
    private List<Integer> list;
    private Stack<Integer> stack;
    private ReentrantLock lock1;
    private ReentrantLock lock2;

    public ThreadB(List<Integer> list, Stack<Integer> stack, ReentrantLock lock1, ReentrantLock lock2) {
        this.list = list;
        this.stack = stack;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        boolean isDone = false;

        while(!isDone) {
            boolean firstLockRequired = false;
            boolean secondLockRequired = false;
            try {
                secondLockRequired = lock2.tryLock(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println("Lock2 was not acquired.");
            }
            System.out.println(Thread.currentThread().getName() + "acquires the second lock.");

            try {
                firstLockRequired = lock1.tryLock(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println("Lock2 was not acquired.");
            }
            if(firstLockRequired && secondLockRequired) {
                if(!stack.empty()) {
                    Integer integer = stack.pop();
                    list.add(integer);
                }
                isDone = true;
                lock1.unlock();
                lock2.unlock();
                System.out.println("Both two locks are released after operation");
            } else {
                if(firstLockRequired) {
                    lock1.unlock();
                    System.out.println("ThreadB releases lock1 because lock2 was not acquired.");
                    try {
                        int timeout = new Random().nextInt(500);
                        if(timeout < 0) {
                            System.out.println("Negative timeout value: " + timeout);
                        }
                        Thread.sleep(timeout);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(secondLockRequired) {
                    lock2.unlock();
                    System.out.println("ThreadB releases lock2 because lock1 was not acquired");
                    try {
                        Thread.sleep(new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


