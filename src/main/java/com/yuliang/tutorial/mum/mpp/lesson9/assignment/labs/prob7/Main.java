package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob7;

import com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob1.partC.Employee;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 5, -2, 0, -3, -1, -5, -4);
		//expected output: [0, -1, -2, -3, -4, 4, -5, 5]
		ordering1(intList);
		List<String> stringList = Arrays.asList("cba", "efg", "doe", "fie", "set");
		//expected output: [cba, fie, doe, efg, set]
		ordering2(stringList);

		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("jim", 50000));
		employees.add(new Employee("jim", 60000));
		employees.add(new Employee("tim", 60000));
		ordering3(employees);
		testOptionalWithoutNPE();


	}
	
	//Orders the integers according to this pattern:
	// 0, -1, 1, -2, 2, -3, 3, . . .
	//Using this ordering, this method sorts the list as part of 
	//a stream pipeline, and prints to the console
    static Comparator<Integer> integerComparator1 = (Integer a, Integer b) -> Math.abs(a) - Math.abs(b);
	static Comparator<Integer> integerComparator2 = (Integer a, Integer b) -> a - b;
	static Comparator<String> stringReverseComparator = (a, b) -> new StringBuilder(a).reverse().toString().compareTo(new StringBuilder(b).reverse().toString());

	public static void ordering1(List<Integer> list) {
		list.stream()
                .sorted(integerComparator1.thenComparing(integerComparator2))
				.forEach(System.out::print);
		System.out.println();
		list.stream()
				.sorted(Comparator.comparing((Integer a) -> Math.abs(a)).thenComparing((Integer a) -> a))
                .forEach(System.out::print);
	}
	
	//Orders words by first reversing each and comparing 
	//in the usual way.  So 
	//    cba precedes bed
	//since
	//    cba.reverse() precedes bed.reverse()
	//in the usual ordering
	//Using this ordering, this method sorts the list as part of 
	//a stream pipeline, and prints to the console
	public static void ordering2(List<String> words) {
		System.out.println();
		System.out.println(words.stream()
		.sorted(stringReverseComparator)
		.collect(Collectors.toList()));
	}

	public static void ordering3(List<Employee> employees) {
		employees.stream()
				.sorted(Comparator.comparing((Employee e) -> e.getName()).thenComparing((Employee e) -> e.getSalary()).reversed()) //Here the reversed() will reverse both the name and salary order.
                .sorted(Comparator.comparing((Employee e) -> e.getName()).thenComparing(Comparator.comparing((Employee::getSalary)).reversed()))
				.forEach(System.out::println);
	}

	public static void testOptional() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add(null);

		Optional<String> first = strings.stream()
				.findFirst();

		String s = first.isPresent() ? first.get() : "Not found";
		System.out.println(s + "hello world");
	}

	public static void testOptionalWithoutNPE() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add(null);

		Optional<String> first = strings.stream()
				.filter(Objects::nonNull) //Filter out all the null values, so that findFirst will not have NPE.
				.findFirst();

		String s = first.isPresent() ? first.get() : "Not found";
		System.out.println(s);
	}

}
