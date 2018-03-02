package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2;

import java.util.ArrayList;
import java.util.List;

public class BuildingApartmentFactory {

    //Create a Building
    public static Building addBuilding(double maintenanceFee) {
        Building building = new Building(maintenanceFee);
        return building;
    }

    //Create a apartment
    public static Apartment createApartment(double rent, Building building) {
        Apartment apartment = new Apartment(rent, building);
        return apartment;
    }

    //Create instance of LandLard with empty Building list.
    public static LandLard createLandLord() {
        LandLard landLard = new LandLard(new ArrayList<Building>());
        return landLard;
    }
}
