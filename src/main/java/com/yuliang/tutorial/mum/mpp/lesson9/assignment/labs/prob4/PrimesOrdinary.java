package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob4;


public class PrimesOrdinary {
    public static int nextPrimeNumber(int n) {
        if (n<2)return 2;

        int next = n + 1;

        while(!isPrimeNum(next)) {
            next = next + 1;
        }
        return next;
    }

    public static boolean isPrimeNum(int num) {
        if(num < 2) return false;

        for(int i = 2; i <= num /2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
