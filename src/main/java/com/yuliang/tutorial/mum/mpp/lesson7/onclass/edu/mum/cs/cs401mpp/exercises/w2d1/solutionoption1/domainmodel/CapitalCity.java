package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption1.domainmodel;

public final class CapitalCity {
	private final String cityName;
	private final Country country;
	
	CapitalCity(String cityName, Country country) {
		this.cityName = cityName;
		this.country = country;
	}
	
	String getCityName() { return this.cityName; }
	
	Country getCountry() { return this.country; }
}
