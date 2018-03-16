package com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob1.partD;

public class MyCls implements MyInterface{

    private String name;

    public MyCls(String name) {
        this.name = name;
    }

    @Override
    public void act() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        MyCls tom = new MyCls("tom");
        System.out.println(tom);
    }


}
