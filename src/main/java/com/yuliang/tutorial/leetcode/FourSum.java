package com.yuliang.tutorial.leetcode;


import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A )
            for(int b : B)
                map.put(a+b, map.getOrDefault(a+b, 0)+1);
        int res = 0;
        for(int c : C)
            for(int d : D){
                if(map.containsKey(-c-d))
                    res += map.get(-c-d);
            }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2};
        int[] b = {-1,-2,-2};
        int[] c = {-1,2};
        int[] d = {0,2};

        System.out.println(fourSumCount1(a,b,c,d));
    }
}
