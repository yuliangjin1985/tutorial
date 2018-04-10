package com.yuliang.tutorial.concurrency;

public class SerialMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] resultSerial) {
        for(int i=0;i<matrix1.length;i++) {
            for(int j=0;j<matrix2.length;j++) {
                for(int k=0;k<matrix1[0].length;k++) {
                    resultSerial[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}
