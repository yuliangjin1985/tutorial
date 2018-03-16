package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob8;

import java.util.Optional;

public class OrderItem {
	private Product product;
	private int quantityRequested;
	private double totalPrice;
	//package level constructor
	OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantityRequested = quantity;
		totalPrice = product.getUnitPrice() * quantity;
	}
	@Override
	public String toString() {
		return "   " + product.getProductId() + ": " + quantityRequested + ", " + product.getUnitPrice();
	}
	public Optional<Product> getProduct() {
		return Optional.of(product);
	}
	public int getQuantityRequested() {
		return quantityRequested;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	
}
