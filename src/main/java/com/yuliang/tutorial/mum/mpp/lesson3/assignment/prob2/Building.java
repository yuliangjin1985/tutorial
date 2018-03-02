package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Building {

    private double maintenanceFee;
    private List<Apartment> apartmentList;

    Building(double maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
        this.apartmentList = new ArrayList<Apartment>();
    }

    public void setApartmentList(List<Apartment> apartmentList) {
        this.apartmentList = apartmentList;
    }

    public void addApartment(Apartment apartment) {
        apartmentList.add(apartment);
    }


    public double getProfit() {
        return this.apartmentList.stream()
                .map(apartment -> apartment.getRent())
                .reduce(0.0, Double::sum) - maintenanceFee;
    }
}
