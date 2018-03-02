package com.yuliang.tutorial.mum.mpp.lesson4.onclass.company;

import java.util.List;

public class Department {

    private String name;

    private String location;

    private List<Position> positions;

    public double computeSalary() {
        return positions.stream()
                .map(position -> position.getSalary())
                .reduce(0.0, Double::sum);
    }
}
