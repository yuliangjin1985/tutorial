package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3;

import org.aspectj.weaver.ast.Or;

import java.time.LocalDate;
import java.util.List;

public class CustOrderFactory {
    private static Customer customer;

    public CustOrderFactory() {
    }

    //create a customer without any order
    public static Customer createCustomer(String name) {
        Customer customer = new Customer(name);
        return customer;
    }

    //add items to a new order, then add this order to a specific customer.
    public static void addOrder(Customer customer, LocalDate orderDate, List<String> itemNames) {
        Order order = Order.newOrder(customer, orderDate);
        for (String itemName : itemNames) {
            order.getItems().add(new Item(itemName));
        }
    }
}
