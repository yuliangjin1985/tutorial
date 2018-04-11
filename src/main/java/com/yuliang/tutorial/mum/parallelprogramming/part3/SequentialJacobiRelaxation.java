package com.yuliang.tutorial.mum.parallelprogramming.part3;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SequentialJacobiRelaxation {

    public static final int n = 12;
    public static final double tolerance = 0.1;
    public static final int threadNums = Runtime.getRuntime().availableProcessors();

    static double [][] a = new double[n][n], b = new double[n][n];
    static double [][] a1 = new double[n][n], b1 = new double[n][n];

    public static void main(String[] args) {
        initializeData();
        sequential(a, b);
        parallel(a1,b1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.printf("%5.1f", a1[i][j]);
            }
            System.out.println();
        }


    }

    private static void parallel(double[][] a1, double[][] b1) {
        SCAN_ARRAY[] tasks = new SCAN_ARRAY[threadNums];
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

        for (SCAN_ARRAY task : tasks) {
            new Thread(task).start();
        }
    }

    private static void sequential(double[][] a, double[][] b) {
        boolean done;
        do {
            for(int i=1;i<n-1;i++) {
                for(int j=1;j<n-1;j++) {
                    b[i][j] = (a[i-1][j] + a[i-1][i+1] + a[i][j-1] + a[i][j+1]) / 4.0;
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
        } while (!done);
    }

    private static void initializeData() {
        for(int i=1;i<n - 1 ;i++) {
            for(int j=1;j<n -1;j++) {
                a[i][j] = 0.0;
                a1[i][j] = 0.0;
            }
        }

        for(int i=0; i<n; i++) {
            a[0][i] = 10.0;
            a[n-1][i] = 10.0;
            a1[0][i] = 10.0;
            a1[n-1][i] = 10.0;
        }

        for(int i=0; i<n; i++) {
            a[i][0] = 10.0;
            a[i][n-1] = 10.0;
            a1[i][0] = 10.0;
            a1[i][n-1] = 10.0;
        }


        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                b[i][j] = 0.0;
                b1[i][j] = 0.0;
            }
        }

        for (double[] doubles : a) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
}

class SCAN_ARRAY implements Runnable {

    int start, end;
    Boolean done;
    CyclicBarrier barrier;
    CyclicBarrier checkBarrier;
    double [][] a, b;
    double tolerance;

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public SCAN_ARRAY(int start, int end, double[][] a, double[][] b, CyclicBarrier barrier, CyclicBarrier checkBarrier, double tolerance) {
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

    double tolerance;

    double[][] a, b;

    SCAN_ARRAY[] tasks;

    public Aggregate(double[][] a, double[][] b, double tolerance, SCAN_ARRAY[] tasks) {
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
            System.out.println("The thread runs times: " + count);
        }
    }
}
