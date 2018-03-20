package com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5;

import java.util.function.Predicate;

public class EmployeeCompanion {

    public static boolean salaryGreaterThan100000(Employee e) {
        return e.getSalary() > 100000;
    }

    public static boolean lastNameAfterM(Employee e) {
        return e.getLastName().charAt(0) > 'M';
    }

    public static Predicate<Employee> lastNameAfterM = employee -> employee.getLastName().charAt(0) > 'M';
    public static Predicate<Employee> salaryGreaterThan100000 = employee -> employee.getSalary() > 100000;
}
