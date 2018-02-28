package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2B;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    //Unique order id
    private String orderNum;

    private List<OrderLine> orderLines;

    public Order(String defaultName) {
        //There has to be one default OrderLine in the Order instance.
        OrderLine aDefault = new OrderLine(defaultName, this);
        this.orderLines = new ArrayList<OrderLine>();
        this.orderLines.add(aDefault);
        this.orderNum = UUID.randomUUID().toString();
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }
    public void addOrderLine(String orderLineName, Order order) {
        OrderLine line1 = new OrderLine(orderLineName, order);
        this.orderLines.add(line1);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", orderLines=" + orderLines +
                '}';
    }
}
