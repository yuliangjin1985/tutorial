package com.yuliang.tutorial.parallelprogramming.lesson8;

import java.util.ArrayList;
import java.util.List;

public class ParallelStack<E> {

    private static int initSize = 200;
    private int top = 0;

    private Object[] elements;

    public ParallelStack() {
        elements = new Object[initSize];
    }

    public synchronized void push(E e) {
        if(top >= 200) {
            throw new RuntimeException("Out of index exception");
        }
        elements[top++] = e;
    }

    public synchronized E pop() {
        if(top < 0) {
            throw new RuntimeException("The stack is already empty");
        }

        E e = (E)elements[--top];
        return e;
    }

    public synchronized void clear() {
        this.top = -1;
    }

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        ParallelStack<Integer> stack = new ParallelStack<>();
        ThreadA a = new ThreadA(stack);
        ThreadA b = new ThreadA(stack);
        ThreadA c = new ThreadA(stack);

        threadList.add(new Thread(a));
        threadList.add(new Thread(b));
        threadList.add(new Thread(c));

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(stack.top);
    }
}

class ThreadA implements Runnable {


    private ParallelStack<Integer> stack;

    public ThreadA(ParallelStack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for(int i=0;i<50;i++) {

            stack.push(i);
            System.out.println("Push a number: " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer integer = stack.pop();
            System.out.println("Pop a number: " + integer);
        }
    }
}
