package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob4;

import java.util.Arrays;

public class Admin {

	public static double computeTotalRent(Object[] objects) {
		return Arrays.stream(objects)
				.filter(p -> p instanceof Property)
				.map(p -> (Property)p)
				.map(p -> p.computeRent())
				.reduce(0.0, Double::sum);
	}
}
