package com.yuliang.tutorial.mum.mpp.lesson4.assignment.prob4E;

import java.util.List;

public class Admin {
	public static double computeUpdatedBalanceSum(List<Employee> list) {
		//implement
		return list.stream()
				.map(employee -> employee.computeUpdatedBalanceSum())
				.reduce(0.0, Double::sum);
	}
}
