package com.yuliang.tutorial.basic.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock{
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
        lock1.lock();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "acquires the first lock.");
        lock2.lock();
        System.out.println(Thread.currentThread().getName() + "acquires the second lock.");
        if(!list.isEmpty()) {
            Integer integer = list.remove(list.size() - 1);
            stack.push(integer);
        }
        lock1.unlock();
        lock2.unlock();
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
        lock2.lock();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "acquires the second lock.");
        lock1.lock();
        System.out.println(Thread.currentThread().getName() + "acquires the first lock.");
        if(!stack.empty()) {
            Integer integer = stack.pop();
            list.add(integer);
        }
        lock1.unlock();
        lock2.unlock();
    }
}


