package com.yuliang.tutorial.mum.mpp.lesson4.onclass.company;

import java.time.LocalDate;

public class Employee {

    private String employeeId;

    private String firstName;

    private String middleInitial;

    private String lastName;

    private LocalDate birthDate;

    private String SSN;

    private double salary;

    private Position position;

    public Employee() {
    }

    public double getSalary() {
        return this.salary;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee(String employeeId, String firstName, String middleInitial, String lastName, LocalDate birthDate, String SSN, double salary, Position position) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.SSN = SSN;
        this.salary = salary;
        this.position = position;
    }
}
