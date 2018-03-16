package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption1.domainmodel;

public final class Country {
	private final String countryName;
	private final CapitalCity capitalCity;
	
	public Country(String countryName, String cityName) {
		this.countryName = countryName;
		this.capitalCity = new CapitalCity(cityName, this);
	}
	
	String getCountryName() { return this.countryName; }
	
	CapitalCity getCapitalCity() { return this.capitalCity; }
	
	@Override
	public String toString() {
		return String.format("Country: %s; Capital City: %s.", this.countryName, this.capitalCity.getCityName());
	}
}
