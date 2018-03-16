package com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob2;

public final class Rectangle implements Polygon{
	final private double width;
	final private double length;
	final private double[] sides = new double[4];

	@Override
	public double[] getSides() {
		return sides;
	}

//	using the default implementation for Polygon instances

//	@Override
//	public double computePerimeter() {
//		System.out.println("Count perimeter");
//		double area =  2 * (width + length);
//		return area;
//	}

	public Rectangle(double width, double length) {	
		this.width = width;
		this.length = length;
		this.sides[0] = width;
		this.sides[1] = length;
		this.sides[2] = length;
		this.sides[3] = width;
	}
	
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
}
