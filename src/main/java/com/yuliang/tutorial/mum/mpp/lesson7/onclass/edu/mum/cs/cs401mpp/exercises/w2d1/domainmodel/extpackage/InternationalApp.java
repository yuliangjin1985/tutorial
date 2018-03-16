package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.domainmodel.extpackage;

import com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.domainmodel.Country;
import com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.domainmodel.CountryFactory;

public class InternationalApp {
    public static void main(String[] args) {
        Country united_states = CountryFactory.addacountry("United States", "Washington, DC");
        Country ireland = CountryFactory.addacountry("Ireland", "Dublin");
        Country india = CountryFactory.addacountry("India", "New Delhi");

        Country[] countries = {united_states, ireland, india};

        for (Country country : countries) {
            System.out.println("Country: " + country.getCountryName() + "; Capital City: " + country.getCapital().getCityName());
        }

    }
}
