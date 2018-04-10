package com.yuliang.tutorial.concurrency;

import java.util.Random;

public class MatrixGenerator {
    public static double[][] generate(int rows, int columns) {
        Random random = new Random();
        double[][] doubles = new double[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                doubles[i][j] = random.nextDouble() * 10;
            }
        }
        return doubles;
    }
}
