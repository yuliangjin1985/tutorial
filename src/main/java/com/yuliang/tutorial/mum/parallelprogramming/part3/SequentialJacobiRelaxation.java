package com.yuliang.tutorial.mum.parallelprogramming.part3;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SequentialJacobiRelaxation {

    public static final int n = 10002;
    public static final float tolerance = 0.1f;
    public static final int threadNums = Runtime.getRuntime().availableProcessors();

    static float[][] a = new float[n][n], b = new float[n][n];
    static float[][] a1 = new float[n][n], b1 = new float[n][n];

    public static void main(String[] args) {
        initializeData();
        sequential(a, b);
        parallel(a1,b1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(a[i][j] != a1[i][j]) {
                    System.out.print("The result is not equal." + "i: " +i + "j:" + j);
                    System.out.print("a[i][j]=" + a[i][j]);
                    System.out.print("a1[i][j]=" + a1[i][j]);
                }
            }
        }
    }

    private static void parallel(float[][] a1, float[][] b1) {
        Date start = new Date();
        SCAN_ARRAY[] tasks = new SCAN_ARRAY[threadNums];
        Thread[] threads = new Thread[threadNums];
        Aggregate aggregate = new Aggregate(a1, b1, tolerance, tasks);
        CyclicBarrier barrier = new CyclicBarrier(threadNums);
        CyclicBarrier checkBarrier = new CyclicBarrier(threadNums, aggregate);

        for(int i=0;i<threadNums;i++) {
            int step = (n-2)/threadNums;
            if(i != threadNums -1) {
               tasks[i] = new SCAN_ARRAY(i * step + 1, (i + 1) * step, a1, b1, barrier, checkBarrier, tolerance);

            } else {
                tasks[i] = new SCAN_ARRAY(i * step + 1, n - 2, a1, b1, barrier, checkBarrier, tolerance);
            }
        }

        for(int i=0;i<threadNums;i++) {
            threads[i] = new Thread(tasks[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Date end = new Date();
        System.out.println("Parallel solution used time: " + (end.getTime() - start.getTime()));
    }

    private static void sequential(float[][] a, float[][] b) {
        Date start = new Date();
        boolean done;
        int count = 0;
        do {
            for(int i=1;i<n-1;i++) {
                for(int j=1;j<n-1;j++) {
                    b[i][j] = (a[i-1][j] + a[i+1][j] + a[i][j-1] + a[i][j+1]) / 4.0f;
                }
            }

            done = true;

            for(int i=1;i<n-1;i++) {
                for(int j=1;j<n-1;j++) {
                    if(Math.abs(b[i][j] - a[i][j]) > tolerance) {
                        done = false;
                    }
                    a[i][j] = b[i][j];
                }
            }
            count++;
        } while (!done);
        Date end = new Date();
        System.out.println("For sequential solution the loop logic runs times: " + count);
        System.out.println("Parallel solution used time: " + (end.getTime() - start.getTime()));
    }

    private static void initializeData() {
        for(int i=1;i<n - 1 ;i++) {
            for(int j=1;j<n -1;j++) {
                a[i][j] = 0.0f;
                a1[i][j] = 0.0f;
            }
        }

        for(int i=0; i<n; i++) {
            a[0][i] = 10.0f;
            a[n-1][i] = 10.0f;
            a1[0][i] = 10.0f;
            a1[n-1][i] = 10.0f;
        }

        for(int i=0; i<n; i++) {
            a[i][0] = 10.0f;
            a[i][n-1] = 10.0f;
            a1[i][0] = 10.0f;
            a1[i][n-1] = 10.0f;
        }


        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                b[i][j] = 0.0f;
                b1[i][j] = 0.0f;
            }
        }

//        for (float[] doubles : a) {
//            for (double aDouble : doubles) {
//                System.out.print(aDouble + " ");
//            }
//            System.out.println();
//        }
    }
}

class SCAN_ARRAY implements Runnable {

    int start, end;
    Boolean done;
    CyclicBarrier barrier;
    CyclicBarrier checkBarrier;
    float [][] a, b;
    float tolerance;

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public SCAN_ARRAY(int start, int end, float[][] a, float[][] b, CyclicBarrier barrier, CyclicBarrier checkBarrier, float tolerance) {
        this.start = start;
        this.end = end;
        this.a = a;
        this.b = b;
        this.barrier = barrier;
        this.checkBarrier = checkBarrier;
        this.tolerance = tolerance;
    }

    @Override
    public void run() {

        try {
            do {
                for (int i = start; i <= end; i++) {
                    for (int j = 1; j < a.length - 1; j++) {
                        b[i][j] = (a[i - 1][j] + a[i + 1][j] + a[i][j - 1] + a[i][j + 1]) / 4;
                    }
                }
                barrier.await();

                done = true;
                for (int i = start; i <= end; i++) {
                    for (int j = 1; j < a.length - 1; j++) {
                        if(Math.abs(a[i][j] - b[i][j]) > tolerance) {
                            done = false;
                        }
                        a[i][j] = b[i][j];
                    }
                }
                checkBarrier.await();//&& , set to each thread.
            } while (!done);
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//Compute global done for different thread
class Aggregate implements Runnable {

    volatile int count = 0;

    float tolerance;

    float[][] a, b;

    SCAN_ARRAY[] tasks;

    public Aggregate(float[][] a, float[][] b, float tolerance, SCAN_ARRAY[] tasks) {
        this.a = a;
        this.b = b;
        this.tolerance = tolerance;
        this.tasks = tasks;
    }

    @Override
    public void run() {
        boolean done = true;
        count++;

        for (SCAN_ARRAY task : tasks) {
            done = done && task.getDone();
        }


        for (SCAN_ARRAY task : tasks) {
            task.setDone(done);
        }

        if(done) {
            System.out.println("The aggregator thread runs times: " + count);
        }
    }
}
