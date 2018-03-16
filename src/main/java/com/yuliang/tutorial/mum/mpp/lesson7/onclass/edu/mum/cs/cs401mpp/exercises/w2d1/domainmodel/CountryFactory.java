package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.domainmodel;

public class CountryFactory {
    public static Country addacountry(String countryName, String capitalName) {
        Country country = new Country(countryName, capitalName);
        return country;
    }
}
