package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob4;

public class Driver {

	public static void main(String[] args) {

		Object[] objects = { new House(9000), new Condo(2), new Trailer() };
		double totalRent = Admin.computeTotalRent(objects);
		System.out.println(totalRent);


	}
}
