package com.yuliang.tutorial.mum.mpp.lesson7.onclass.edu.mum.cs.cs401mpp.exercises.w2d1.domainmodel;

public final class CapitalCity {

    private String cityName;

    private Country country;

    public CapitalCity(String cityName, Country country) {
        this.cityName = cityName;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

    void setCountry(Country country) {
        this.country = country;
    }
}
