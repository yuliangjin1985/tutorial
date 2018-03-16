package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption2.domainmodel;

public class CountryAndCapitalCity {
	private final Country country;
	private final CapitalCity capitalCity;
	
	CountryAndCapitalCity(Country c, CapitalCity cc) {
		this.country = c;
		this.capitalCity = cc;
	}
	
	public Country getCountry() { return this.country; }
}
