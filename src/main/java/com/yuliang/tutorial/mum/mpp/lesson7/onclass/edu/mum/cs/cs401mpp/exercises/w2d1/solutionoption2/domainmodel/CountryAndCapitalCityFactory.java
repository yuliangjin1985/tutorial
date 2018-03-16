package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption2.domainmodel;

public class CountryAndCapitalCityFactory {
	
	public static CountryAndCapitalCity createCountryAndCapitalCity(String countryName, String cityName) {
		CapitalCity cc = new CapitalCity(cityName);
		Country c = new Country(countryName, cc);
		cc.setCountry(c);
		return new CountryAndCapitalCity(c, cc);
	}
}
