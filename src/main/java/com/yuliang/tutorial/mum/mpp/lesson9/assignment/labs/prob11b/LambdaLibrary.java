package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob11b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final FourFunction<List<Employee>, Integer, Character, Character, List<String>> NAMES1 =
            (employees, minSalary, start, end) -> employees.stream()
                .filter(employee -> employee.getSalary() > minSalary)
                .filter(employee -> employee.getLastName().charAt(0) > start && employee.getLastName().charAt(0) < end)
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());

    public static final FourFunction<List<Employee>, Integer, Character, Character, List<String>> NAMES_2 =
            (employees, minSalary, start, end) -> employees.stream()
                    .filter(employee -> employee.getSalary() > minSalary)
                    .filter(employee -> employee.getLastName().charAt(0) > start && employee.getLastName().charAt(0) < end)
                    .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                    .collect(Collectors.toList());
}
