package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob4;

public class House  extends Property{

	private double lotSize;
	
	
	public House(double lotSize) {
		this.lotSize = lotSize;
	}


	@Override
	public double computeRent(){
		return 0.1 * lotSize;
	}
}
