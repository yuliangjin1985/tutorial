package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Order> orders;
	Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	void addOrder(Order order) {
		orders.add(order);
	}
	public String getName() {
		return name;
	}
	public List<Order> getOrders() {
		return orders;
	}
}
