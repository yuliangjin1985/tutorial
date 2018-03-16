package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob10;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringStreamExample {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("Bill", "Thomas", "Mary");
        System.out.println(names.collect(Collectors.joining(",")));

        //prob10, c, output max and min using one stream
        IntStream myIntStream = IntStream.generate(() -> new Random().nextInt()).limit(10);
        Comparator<Integer> intComparator = (a, b) -> a - b;

//        System.out.println(myIntStream.max().orElse(Integer.MIN_VALUE));
        System.out.println(myIntStream.summaryStatistics());
    }
}
