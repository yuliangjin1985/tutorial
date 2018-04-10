package com.yuliang.tutorial.concurrency;

import java.util.Date;

public class SerialMain {
    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(500, 500);
        double matrix2[][] = MatrixGenerator.generate(500, 500);
//        double matrix1[][] = MatrixGenerator.generate(2000, 2000);
//        double matrix2[][] = MatrixGenerator.generate(2000, 2000);
        double resultSerial[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date start=new Date();
        SerialMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());

        double resultParallel[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date startParallel =new Date();
        ParallelIndividualMultiplier.multiply(matrix1,matrix2,resultParallel);
        Date endParallel = new Date();
        System.out.printf("Parallel: %d%n",endParallel.getTime()-startParallel.getTime());

        double resultParallelByRow[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date startParallelByRow =new Date();
        ParallelRowMultiplier.multiply(matrix1,matrix2,resultParallelByRow);
        Date endParallelByRow = new Date();
        System.out.printf("Parallel By Row: %d%n",endParallelByRow.getTime()-startParallelByRow.getTime());

        double resultParallelGroup[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date startParallelGroup=new Date();
        ParallelGroupMultiplier.multiply(matrix1,matrix2,resultParallelGroup);
        Date endParallelGroup= new Date();
        System.out.printf("Parallel By Cores Group: %d%n",endParallelGroup.getTime()-startParallelGroup.getTime());

    } }
