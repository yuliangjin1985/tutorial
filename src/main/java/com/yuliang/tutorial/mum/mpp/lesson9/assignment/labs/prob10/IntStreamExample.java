package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob10;

import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        IntStream stream = IntStream.generate(() -> 1).distinct();
        stream.forEach(System.out::println);
    }
}
