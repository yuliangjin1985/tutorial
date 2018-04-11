package com.yuliang.tutorial.parallelprogramming.lesson8;

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
        ParallelStack parallelStack = new ParallelStack();
        for(int i=0;i<200;i++) {
            parallelStack.push(2 * i);
        }

        System.out.println(parallelStack.pop());
        parallelStack.clear();
        System.out.println(parallelStack.pop());

//        Runnable runnable = () -> {
//            parallelStack.push();
//        };
    }
}
