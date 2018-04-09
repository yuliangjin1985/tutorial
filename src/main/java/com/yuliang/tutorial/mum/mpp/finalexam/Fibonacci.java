package com.yuliang.tutorial.mum.mpp.finalexam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    //Using stream to return the fibonacci number
    public static void main(String[] args) {
        int a, b, n;
        a = 0; b = 1; n = 10;
        List<Integer> fibs = getFibnocci(a, b, n);

        for (Integer fib : fibs) {
            System.out.println(fib);
        }
    }

    private static List<Integer> getFibnocci(int a, int b, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        return Stream.iterate(new int[]{a, b}, (int[] array) -> new int[]{array[1], array[0] + array[1]})
                .limit(n)
                .map(array -> array[0])
                .collect(Collectors.toList());
    }
}
