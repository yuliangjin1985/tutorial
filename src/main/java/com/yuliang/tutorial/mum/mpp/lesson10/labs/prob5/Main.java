package com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000)).stream();
		
//		  System.out.println(emps
//				    .filter(e -> (e.getSalary() > 100000))
//				    .filter(e -> (e.getLastName().charAt(0) > 'M'))
//				    .map(e -> fullName(e))
//				    .sorted()
//				    .collect(Collectors.joining(", ")));

		  printEmps(emps.collect(Collectors.toList()));
	}

	private static void printEmps(List<Employee> emps) {
		System.out.println(asString(emps));
	}

	public static String asString(List<Employee> employees) {
		return employees.stream()
				.filter(employee -> employee.getSalary() > 100000)
				.filter(employee -> employee.getLastName().charAt(0) > 'M')
				.map(employee -> fullName(employee))
				.sorted()
				.collect(Collectors.joining(", "));
	}



	private static String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}

}
