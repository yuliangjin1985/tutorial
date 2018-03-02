package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2.ext;

import com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2.Apartment;
import com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2.Building;
import com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2.BuildingApartmentFactory;
import com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2.LandLard;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LandLard landLard = BuildingApartmentFactory.createLandLord();

        Building building1 = BuildingApartmentFactory.addBuilding(300.00);
        Building building2 = BuildingApartmentFactory.addBuilding(200.00);
        Apartment apartment1 = BuildingApartmentFactory.createApartment(300.15, building1);
        Apartment apartment2 = BuildingApartmentFactory.createApartment(900.95, building1);
        Apartment apartment3 = BuildingApartmentFactory.createApartment(380.15, building1);
        Apartment apartment4 = BuildingApartmentFactory.createApartment(800.15, building2);
        Apartment apartment5 = BuildingApartmentFactory.createApartment(700.15, building2);
        Apartment apartment6 = BuildingApartmentFactory.createApartment(990.15, building2);

        List<Apartment> apartments1 = Arrays.asList(apartment1, apartment2, apartment3);
        List<Apartment> apartments2 = Arrays.asList(apartment4, apartment5, apartment6);
        building1.setApartmentList(apartments1);
        building2.setApartmentList(apartments2);

        landLard.getBuildingList().add(building1);
        landLard.getBuildingList().add(building2);

        System.out.println(landLard.getProfit());
    }
}
