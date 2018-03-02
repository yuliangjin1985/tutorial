package com.yuliang.tutorial.mum.mpp.lesson3.assignment.prob2;

import java.util.List;

public class LandLard {

    private List<Building> buildingList;

    private double profit;

    public double getProfit() {
        return caculateProfit();
    }

    private double caculateProfit() {
        double profit = 0.0;

        profit = buildingList.stream()
                .map(building -> building.getProfit())
                .reduce(0.0, Double::sum);
        return profit;
    }

    public List<Building> getBuildingList() {
        return this.buildingList;
    }

    LandLard(List<Building> buildings) {
        this.buildingList = buildings;
    }
}
