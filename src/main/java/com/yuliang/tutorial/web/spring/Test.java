package com.yuliang.tutorial.web.spring;

import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        int sumFirst10Cubes = sumFirstNCubes(10);
        System.out.println(sumFirst10Cubes);

    }

    private static int sumFirstNCubes(int n) {

        /* Implement your solution here */
        return IntStream.iterate(1, x -> x + 1)
                .limit(n)
                .sum();

    }

}
