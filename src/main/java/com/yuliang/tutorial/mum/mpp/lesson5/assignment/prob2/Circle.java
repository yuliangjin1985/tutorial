package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2;

public final class Circle implements CloseableCurve{

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double computeArea() {
        return Math.PI * radius * radius;
    }
}
