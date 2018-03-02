package com.yuliang.tutorial.mum.mpp.lesson4.assignment.prob4E;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;

	private List<Account> accountList;

	public Employee(String name) {
		this.name = name;
		this.accountList = new ArrayList<Account>();
	}

	public String getName() {
		return name;
	}

	public void addAccount(Account account) {
		this.accountList.add(account);
	}

	public double computeUpdatedBalanceSum() {
		//implement
		return this.accountList.stream()
				.map(account -> account.computeUpdatedBalance())
				.reduce(0.0, Double::sum);
	}
}
