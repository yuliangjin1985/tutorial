package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.domainmodel;

public final class Country {

    private final String countryName;

    private CapitalCity capitalCity;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country(String countryName, String capitalName) {
        this.countryName = countryName;
        this.capitalCity = new CapitalCity(capitalName, this);
    }

    public String getCountryName() {
        return countryName;
    }

    public CapitalCity getCapital() {
        return capitalCity;
    }
}
