package com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob2;

public class Ellipse implements ClosedCurve{

    private final double a;

    private final double E;

    public Ellipse(double a, double e) {
        this.a = a;
        E = e;
    }

    @Override
    public double computePerimeter() {
        return 4*a*E;
    }
}
