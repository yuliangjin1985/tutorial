package com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob2;

import java.util.Arrays;

public interface Polygon extends ClosedCurve{

    double[] getSides();

    @Override
    default double computePerimeter() {
        System.out.println("Using polygon to compute perimeter");
        return Arrays.stream(getSides())
                .reduce(0.0, Double::sum);
    }
}
