package com.yuliang.tutorial.parallelprogramming.lesson8;

import java.util.Random;

public class SequentialJacobiRelaxation {

    public static final int n = 100;
    public static final double tolerance = 0.1;

    static double [][] a = new double[n][n], b = new double[n][n];
    static double change;

    public static void main(String[] args) {
        initializeData();

        boolean done = false;
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
                        a[i][j] = b[i][j];
                    }
                }
            }
        } while (!done);

        for(int i=1;i<n-1;i++) {
            for(int j=1;j<n-1;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void initializeData() {
        Random random = new Random();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                a[i][j] = random.nextDouble();
                b[i][j] = 0.0;
            }
        }
    }
}
