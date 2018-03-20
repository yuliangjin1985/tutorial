package com.yuliang.tutorial.mum.mpp.lesson11.onclass;

import java.util.ArrayList;
import java.util.List;

public class SuperWildCard {

    public static void main(String[] args) {
        List<? super Integer> nums = new ArrayList<>();

        nums.add(5);

        System.out.println(nums.get(0));

//        Integer integer = nums.get(0); //Compile error
        Object object = nums.get(0);

    }
}
