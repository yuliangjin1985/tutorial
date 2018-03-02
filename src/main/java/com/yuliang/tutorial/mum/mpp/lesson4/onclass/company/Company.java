package com.yuliang.tutorial.mum.mpp.lesson4.onclass.company;

import java.util.List;

public class Company {
    private String name;
    private List<Department> departmentList;

    public Company(String name) {
        this.name = name;
    }

    public double computeSalary() {
        return departmentList.stream()
                .map(department -> department.computeSalary())
                .reduce(0.0, Double::sum);
    }

}
