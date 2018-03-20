package com.yuliang.tutorial.mum.mpp.lesson11.onclass;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;

//        nums.add(3);
        //Compile error
        //Because when the extends wild card used to define a parameterized type, the type
        //can not be used to add elements.

        nums.add(null); //Only null could be added
    }
}
