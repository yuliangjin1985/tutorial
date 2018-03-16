package com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob2;

public class EquilateralTriangle implements Polygon{

    private final double sides[] = new double[3];

    @Override
    public double[] getSides() {
        return sides;
    }

    public EquilateralTriangle(double side) {
        sides[0] = side;
        sides[1] = side;
        sides[2] = side;
    }
}
