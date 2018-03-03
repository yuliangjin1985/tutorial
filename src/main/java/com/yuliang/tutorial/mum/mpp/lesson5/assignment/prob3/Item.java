package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob3;

public class Item {
	String name;
	//package access level
	Item(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
}
