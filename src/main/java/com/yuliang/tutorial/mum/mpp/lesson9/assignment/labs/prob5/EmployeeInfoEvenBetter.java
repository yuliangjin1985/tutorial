package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob5;

import java.util.*;
import java.util.function.Function;

public class EmployeeInfoEvenBetter {



	public void sort(List<Employee> employees, String firstOrder, String secondOrder) {
		Function<Employee, String> byName = e -> e.getName();
		Function<Employee, Integer> bySalary = e -> -e.getSalary(); //use - instead of reversed
		Comparator<Employee> comparator1 = Comparator.comparing(byName).thenComparing(Comparator.comparing(bySalary));
		Comparator<Employee> comparator2 = Comparator.comparing(bySalary).thenComparing(Comparator.comparing(byName));
		HashMap<Pair, Comparator<Employee>> comparatorHashMap = new HashMap<Pair, Comparator<Employee>>();
		comparatorHashMap.put(new Pair("name", "salary"), comparator1);
		comparatorHashMap.put(new Pair("salary", "name"), comparator2);
    	Collections.sort(employees, comparatorHashMap.get(new Pair(firstOrder, secondOrder)));
	}
	
	
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Rick", 50000));
		emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Tim", 10000));
		EmployeeInfoEvenBetter ei = new EmployeeInfoEvenBetter();
		ei.sort(emps, "name", "salary");
		System.out.println(emps);
		//same instance
		ei.sort(emps, "salary", "name");
		System.out.println(emps);
	}

	static class Pair {

		private String first;

		private String second;

		public Pair(String first, String second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair pair = (Pair) o;
			return Objects.equals(first, pair.first) &&
					Objects.equals(second, pair.second);
		}

		@Override
		public int hashCode() {

			return Objects.hash(first, second);
		}
	}
}
