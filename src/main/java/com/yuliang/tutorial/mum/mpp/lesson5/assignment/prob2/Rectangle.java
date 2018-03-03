package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2;

public final class Rectangle implements CloseableCurve{

    private final double width, length;

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double computeArea() {
        return width * length;
    }
}
