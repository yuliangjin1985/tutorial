package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption1;


import com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.solutionoption1.domainmodel.Country;

public class InternationalApp {

	public static void main(String[] args) {
		
		Country[] countries = new Country[3];
		countries[0] = new Country("United States", "Washington, DC");
		countries[1] = new Country("Ireland", "Dublin");
		countries[2] = new Country("India", "New Delhi");
		
		for(Country c : countries) {
			System.out.println(c);
		}

	}

}
