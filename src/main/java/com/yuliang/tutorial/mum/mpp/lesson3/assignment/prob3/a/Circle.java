package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob3.a;

public class Circle extends Cylinder{

    public Circle() {
    }

    public Circle(double radius, double height) {
        super(radius, height);
    }

    public double computeArea() {
        return Math.PI * getRadius() * getRadius();
    }

    public static void main(String[] args) {
        Circle circle = new Circle(3.5, 0.0);
        System.out.println(circle.computeArea());
    }
}
