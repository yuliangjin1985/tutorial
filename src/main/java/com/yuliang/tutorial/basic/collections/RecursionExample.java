package com.yuliang.tutorial.basic.collections;

import java.util.LinkedList;
import java.util.List;

public class RecursionExample {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int[] nums = {2,3,3,4,1,2,5,6,9,5,6,2,2,2,3,3,3,3};
        for (int num : nums) {
            list.add(num);
        }

        List<Integer> newList = reduceDuplicateRecursively(list);

        for (Integer integer : newList) {
            System.out.println(integer);
        }
    }

    private static List<Integer> reduceDuplicateRecursively(List<Integer> list) {
        if(list == null) return new LinkedList<>();

        if(list.size() <2) return list;

        int temp = list.remove(0);

        List<Integer> partialResult = reduceDuplicateRecursively(list);
        if (partialResult.contains(temp)) {
            return partialResult;
        } else {
            partialResult.add(temp);
            return partialResult;
        }
    }
}
