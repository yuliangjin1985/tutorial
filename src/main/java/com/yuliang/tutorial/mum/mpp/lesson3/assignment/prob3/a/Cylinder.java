package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob3.a;

public class Cylinder {

    private double radius;

    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double computeVolume() {
        return Math.PI * radius * radius * height;
    }

}
