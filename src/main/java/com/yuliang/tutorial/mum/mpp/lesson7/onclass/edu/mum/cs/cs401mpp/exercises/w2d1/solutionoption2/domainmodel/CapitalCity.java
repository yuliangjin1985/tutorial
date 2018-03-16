package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption2.domainmodel;

public class CapitalCity {
	private final String cityName;
	private Country country;
	
	CapitalCity(String cityName) {
		this.cityName = cityName;
	}
	
	CapitalCity(String cityName, Country country) {
		this.cityName = cityName;
		this.country = country;
	}
	
	String getCityName() { return this.cityName; }
	
	Country getCountry() { return this.country; }
	
	void setCountry(Country country) {
		this.country = country;
	}
}
