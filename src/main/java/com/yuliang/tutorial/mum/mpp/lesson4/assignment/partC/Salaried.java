package com.yuliang.tutorial.mum.mpp.lesson4.assignment.partC;

public class Salaried extends Employee{

    private double salary;

    public Salaried(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
