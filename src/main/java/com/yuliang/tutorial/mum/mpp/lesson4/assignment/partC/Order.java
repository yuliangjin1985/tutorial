package com.yuliang.tutorial.mum.mpp.lesson4.assignment.partC;

import java.time.LocalDate;

public class Order {

    private String orderNum;

    private LocalDate orderDate;

    private double orderAmount;

    private Commissioned commissioned;

    public Order(String orderNum, LocalDate orderDate, double orderAmount, Commissioned commissioned) {
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.commissioned = commissioned;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Commissioned getCommissioned() {
        return commissioned;
    }

    public void setCommissioned(Commissioned commissioned) {
        this.commissioned = commissioned;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum='" + orderNum + '\'' +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", commissioned=" + commissioned +
                '}';
    }
}
