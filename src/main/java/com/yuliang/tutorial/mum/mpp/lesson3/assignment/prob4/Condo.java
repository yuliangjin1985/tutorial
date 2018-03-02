package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob4;

public class Condo extends Property{

	private int numberOfFloors;
	
	public Condo(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	@Override
	public double computeRent(){
		return 500 * numberOfFloors;
	}
}
