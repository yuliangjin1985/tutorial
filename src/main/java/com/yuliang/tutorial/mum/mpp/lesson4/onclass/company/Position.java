package com.yuliang.tutorial.mum.mpp.lesson4.onclass.company;

public class Position {

    private String title;

    private String description;

    private Employee employee;

    public Position(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getSalary() {
        return employee == null ? 0.0 : employee.getSalary();
    }
}
