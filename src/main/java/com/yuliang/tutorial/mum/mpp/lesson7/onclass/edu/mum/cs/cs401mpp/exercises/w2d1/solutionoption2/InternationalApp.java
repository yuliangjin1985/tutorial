package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption2;


import com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption2.domainmodel.CountryAndCapitalCity;
import com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption2.domainmodel.CountryAndCapitalCityFactory;

public class InternationalApp {

	public static void main(String[] args) {
		
		CountryAndCapitalCity[] cacaps = new CountryAndCapitalCity[3];
		cacaps[0] = CountryAndCapitalCityFactory.createCountryAndCapitalCity("United States", "Washington, DC");
		cacaps[1] = CountryAndCapitalCityFactory.createCountryAndCapitalCity("Ireland", "Dublin");
		cacaps[2] = CountryAndCapitalCityFactory.createCountryAndCapitalCity("India", "New Delhi");
		
		for(CountryAndCapitalCity cacap : cacaps) {
			System.out.println(cacap.getCountry());
		}
	}

}
