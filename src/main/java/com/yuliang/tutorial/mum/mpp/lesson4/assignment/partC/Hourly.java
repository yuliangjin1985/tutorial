package com.yuliang.tutorial.mum.mpp.lesson4.assignment.partC;

public class Hourly extends Employee{

    private double hourlyWage;

    private int hoursPerWeek;

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage * (hoursPerWeek * 4);
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Hourly(double hourlyWage, int hoursPerWeek) {
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }
}
