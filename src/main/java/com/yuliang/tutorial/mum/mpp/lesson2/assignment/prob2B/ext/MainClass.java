package com.yuliang.tutorial.mum.mpp.lesson2.assignment.prob2B.ext;

import prob2B.Order;

public class MainClass {
    public static void main(String[] args) {
        Order order = new Order("FirstOrderLineName");//There is at least one
        //OrderLine in order to create the instance of Order.
        System.out.println(order.getOrderLines().get(0));

        //add another instance of OrderLine
        order.addOrderLine("Beer", order);
        System.out.println(order.getOrderLines().size());
    }
}
