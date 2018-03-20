package com.yuliang.tutorial.mum.mpp.lesson9.onclass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
//        new Test().printSquares(9);

        List<List<Integer>> original = Arrays.asList(
                Arrays.asList(2,3,5),
                Arrays.asList(2,9,5909),
                Arrays.asList(2,3,5),
                Arrays.asList(2,3,5),
                Arrays.asList(2,3,5,8)

        );

        List<Integer> integerList = original.stream()
                .flatMap(row -> row.stream())
                .collect(Collectors.toList());

        List<List<Integer>> original1 = Arrays.asList(
                Arrays.asList(20,30,50),
                Arrays.asList(200,300,500,800)

        );

        int[][][] array = {{{1,2}, {3,4}}, {{5,6}},{{7,8}}};
        int[][] array1 = {{1,2}, {3,4}};

        Arrays.stream(array1)
                .flatMapToInt(row -> Arrays.stream(row))
                .toArray();

        Arrays.stream(array1)
                .flatMapToInt(row -> Arrays.stream(row))
                .forEach(System.out::println);


        int[] ints = flatArrays(array);
        Arrays.stream(ints).forEach(x -> System.out.println("ints: " + x));

        List<Integer> integers = flatAList(original);

        Stream<String> he = Stream.of("he", "Day", "hello");
//        System.out.println(he.reduce("", (a,b) -> a + " " + b));
        System.out.println(he.collect(Collectors.joining(" ")));
    }

    public void printSquares(int n) {
        IntStream.iterate(1, m -> m+1)
                .limit(n)
                .map(m -> m * m)
                .forEach(System.out::println);
    }

    public static List<Integer> flatAList(List<List<Integer>> originalList) {
        return originalList.stream()
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static int[] flatArrays(int[][] originalArray) {
        return Arrays.stream(originalArray)
                .flatMapToInt(array -> Arrays.stream(array))
                .toArray();
    }

    //flat map a 3D array
    public static int[] flatArrays(int[][][] originalArray) {
        return Arrays.stream(originalArray)
                .map(array -> flatArrays(array))
                .flatMapToInt(array -> Arrays.stream(array))
                .toArray();
    }


}
