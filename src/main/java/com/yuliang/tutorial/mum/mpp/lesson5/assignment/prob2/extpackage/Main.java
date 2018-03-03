package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2.extpackage;

import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2.Circle;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2.CloseableCurve;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2.Rectangle;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob2.Triangle;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3.Customer;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<CloseableCurve> closeableCurves = Arrays.asList(
				new Rectangle(20.00, 1.00),
				new Triangle(10.00, 20.00),
				new Circle(10.00)
		);

		System.out.println(" Sum of Areas" + closeableCurves.stream()
		.map(closeableCurve -> closeableCurve.computeArea())
		.reduce(0.0, Double::sum));
	}
}

		
