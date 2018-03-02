package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob1;


public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false;
		if(aPerson == this) return true;
		if (aPerson instanceof PersonWithJob) {
			return this.equals(((PersonWithJob) aPerson).getPerson());
		}
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
}