package com.yuliang.tutorial.parallelprogramming.lesson8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Visibility {
//    private static boolean done = false;
    private static volatile boolean done = false;

    public static void main(String[] args) {
        Runnable hellos = () -> {
            for(int i=0; i<1000; i++) {
                System.out.println("Hello " + i);
            }
            done = true;
        };

        Runnable goodbye = () -> {
            int i = 1;
            while (!done) {
                i++;
                System.out.println("Increment i: " + i);
            }

            System.out.println("Goodbye " + i);

        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(hellos);
        executorService.execute(goodbye);
    }
}
