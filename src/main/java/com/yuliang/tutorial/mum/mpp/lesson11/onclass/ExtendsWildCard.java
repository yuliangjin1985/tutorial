package com.yuliang.tutorial.mum.mpp.lesson11.onclass;

import java.util.ArrayList;
import java.util.List;

public class ExtendsWildCard {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;

//        nums.add(3); //Compile error
//
//        nums.add(4.5); //Compile error

        nums.add(null); //Only null could be added
    }
}
