package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob14;

import java.util.Optional;

public class MySingletonLazy {

    private static MySingletonLazy instance = null;

    private int counter = 0;


    private MySingletonLazy get() {
        counter++;
        instance = new MySingletonLazy();
        return instance;
    }
//    public static MySingletonLazy getInstance() {
//        if (instance == null) {
//            instance = new MySingletonLazy();
//        }
//
//        return instance;
//    }

    public MySingletonLazy getInstance() {
        System.out.println("Test");
        return Optional.ofNullable(instance).orElseGet(this::get);
    }

    public static void main(String[] args) {
        MySingletonLazy mySingletonLazy = new MySingletonLazy().getInstance();
    }
}
