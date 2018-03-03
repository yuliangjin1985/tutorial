package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3.extpackage;

import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3.CustOrderFactory;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3.Customer;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
//		Customer cust = new Customer("Bob");
//		Order order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Shirt");
//		order.addItem("Laptop");
//
//		order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Pants");
//		order.addItem("Knife set");
//
//		System.out.println(cust.getOrders());

		Customer bob = CustOrderFactory.createCustomer("Bob");
		List<String> items1 = Arrays.asList("pen", "ink", "book");
		List<String> items2 = Arrays.asList("flip flop", "hair dryer", "tooth brush");
		CustOrderFactory.addOrder(bob, LocalDate.of(2018, 2, 5), items1);
		CustOrderFactory.addOrder(bob, LocalDate.of(2018, 2, 6), items2);
		System.out.println(bob.getOrders());

		System.out.println(21>>3<<2^4);
	}
}

		
