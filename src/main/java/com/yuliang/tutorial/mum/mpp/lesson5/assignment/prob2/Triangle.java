package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2;

public final class Triangle implements CloseableCurve{

    private final double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double computeArea() {
        return 0.5 * base * height;
    }
}
