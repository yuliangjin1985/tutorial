package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob3.b;

public class Circle {

    private Cylinder cylinder;

    public Circle() {
    }

    public Circle(Cylinder cylinder) {
        this.cylinder = cylinder;
    }

    public double caculateArea() {
//        return Math.PI * cylinder.getRadius() * cylinder.getRadius();
        return cylinder.computeVolume() / cylinder.getHeight();
    }
}
