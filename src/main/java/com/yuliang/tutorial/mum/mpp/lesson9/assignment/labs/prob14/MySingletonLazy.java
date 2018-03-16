package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob14;

import java.util.Optional;

public class MySingletonLazy {

    private static MySingletonLazy instance = null;


    private MySingletonLazy get() {
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
        return Optional.ofNullable(instance).orElseGet(this::get);
    }
}
