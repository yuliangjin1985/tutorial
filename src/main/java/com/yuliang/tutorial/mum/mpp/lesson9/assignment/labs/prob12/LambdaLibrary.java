package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob12;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final TriFunction<List<Employee>, Integer, Character, List<String>> NAMES =
            (employees, minSalary, start) -> employees.stream()
                    .filter(employee -> employee.getSalary() > minSalary)
                    .filter(employee -> employee.getLastName().charAt(0) >= start && employee.getLastName().charAt(0) <= 'Z')
                    .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                    .collect(Collectors.toList());

    public static final FourFunction<List<Employee>, Integer, Character, Character, List<String>> NAMES1 =
            (employees, minSalary, start, end) -> employees.stream()
                    .filter(employee -> employee.getSalary() > minSalary)
                    .filter(employee -> employee.getLastName().charAt(0) > start && employee.getLastName().charAt(0) < end)
                    .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                    .collect(Collectors.toList());
}
