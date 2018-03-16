package com.yuliang.tutorial.mum.mpp.lesson8.assignment.labs.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MyBiFunction {
    public static void main(String[] args) {

        BiFunction<Double, Double, List<Double>> myFunction =  (x, y) -> {
            ArrayList<Double> doubles = new ArrayList<Double>();
            doubles.add(Math.pow(x, y));
            doubles.add(x * y);
            return doubles;

        };

        System.out.println(myFunction.apply(2.0, 3.0));
    }
}
