package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2B;

public class OrderLine {
    private String orderLineName;
    private Order order;

    OrderLine(String orderLineName, Order order) {
        this.orderLineName = orderLineName;
        this.order = order;
    }

    public String getOrderLineName() {
        return this.orderLineName;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineName='" + orderLineName + '\'' +
                '}';
    }
}
