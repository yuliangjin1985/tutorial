package com.yuliang.tutorial.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ParallelIndividualMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result) {
        List<Thread> threads = new ArrayList<>();

        int row1 = matrix1.length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;

        for(int i=0;i<row1;i++) {
            for(int j=0;j<column2;j++) {
                Thread thread = new Thread(new IndividualMultiplierTask(result, matrix1, matrix2, i, j));
                thread.start();
                threads.add(thread);
            }

            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }



        }
    }

    private static void waitForThreads(List<Thread> threads) {
        for(int i=0;i<threads.size();i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        threads.clear();
    }
}
