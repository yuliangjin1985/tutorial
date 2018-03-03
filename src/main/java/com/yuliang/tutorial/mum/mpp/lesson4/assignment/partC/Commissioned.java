package com.yuliang.tutorial.mum.mpp.lesson4.assignment.partC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee{

    private double commission;

    private double baseSalary;

    private List<Order> orderList;

    public Commissioned(String empId, double baseSalary, double commission) {
        super(empId);
        this.orderList = new ArrayList<>();
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        LocalDate endDate = LocalDate.of(year, month, 1);
        LocalDate startDate = LocalDate.of(year, month - 1, 1);
        //There might be bugs wnen month is 1.
        Double amount = this.orderList.stream()
                .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .map(order -> order.getOrderAmount())
                .reduce(0.0, Double::sum);
        return baseSalary + commission * amount;
    }
}
