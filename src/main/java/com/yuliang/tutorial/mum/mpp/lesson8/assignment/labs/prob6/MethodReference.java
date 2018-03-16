package com.yuliang.tutorial.mum.mpp.lesson8.assignment.labs.prob6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {

    public static void main(String[] args) {

//        Function<String, String> toUpperCase = (String x) -> x.toUpperCase();
        Function<String, String> toUpperCase =String::toUpperCase; //Class::instanceMethod

//        Function<Employee, String> getName = employee -> employee.getName();
        Function<Employee, String> getName = Employee::getName; //Class::instanceMethod

//        BiFunction<String, String, Integer> compare = (x, y) -> x.compareTo(y);
        BiFunction<String, String, Integer> compare = String::compareTo; //Class::instanceMethod

//        BiFunction<Integer, Integer, Double> biConsumer = (Integer x, Integer y) -> Math.pow(x, y);
        BiFunction<Integer, Integer, Double> biConsumer = Math::pow; //Class::staticMethod

//        Function<String, Integer> parseInt = (String x) -> Integer.parseInt(x);
        Function<String, Integer> parseInt = Integer::parseInt; //Class::staticMethod

        EmployeeNameComparator comp = new EmployeeNameComparator();
        Comparator<Employee> employeeComparator1 = (Employee e1, Employee e2) -> comp.compare(e1, e2);
        Comparator<Employee> employeeComparator2 = comp::compare; //object::instanceMethod
//        Comparator<Employee> employeeComparator3 = EmployeeNameComparator::compare; //Class::instanceMethod

        System.out.println(toUpperCase.apply("leo"));
        System.out.println(getName.apply(new Employee("leo")));
        System.out.println(compare.apply("abc", "def"));
        System.out.println(biConsumer.apply(2,5));
        System.out.println(parseInt.apply("34"));
        Employee a = new Employee("a");
        Employee b = new Employee("b");
        System.out.println(employeeComparator1.compare(a, b));
    }
}
