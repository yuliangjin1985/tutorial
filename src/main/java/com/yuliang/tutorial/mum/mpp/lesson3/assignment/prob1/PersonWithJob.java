package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob1;

public class PersonWithJob {
	
	private double salary;

	private Person person;

	public PersonWithJob(String personName, double salary) {
	    this.person = new Person(personName);
	    this.salary = salary;
	}

	public Person getPerson() {
		return person;
	}
	
	public double getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false;

		if(this == aPerson) return true;

		if (aPerson instanceof Person) {
			return this.getPerson().equals((Person) aPerson);
		}

		if(!(aPerson instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPerson;
		boolean isEqual = this.getPerson().equals(p.getPerson()) &&
				this.getSalary()==p.getSalary();
		return isEqual;
	}
	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		PersonWithJob p3 = new PersonWithJob("Joe", 30000);
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));

		//As p1 and p3 are instances of the same Class, they will equaul or not equal
        //constantly.
        //p1.equals(p3) == p3.equals(p1) always return true.
		System.out.println("p3.equals(p1)? " + p3.equals(p1));
		System.out.println("p1.equals(p3)? " + p1.equals(p3));
	}


}
