package com.yuliang.tutorial.leetcode;

import java.util.*;

public class FourSumSolution {

    public static void main(String[] args) {
      int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList();
        if(len < 4) return lists;
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);

//             for(int i=0; i<len-3; i++) {
//                 for(int j=i+1; j<len-2; j++) {
//                     for(int m=j+1; m<len-1; m++) {
//                         for(int n=m+1; n<len; n++) {
//                             if(nums[i] + nums[j] + nums[m] + nums[n] == target) {
//                                 List<Integer> list = new ArrayList();
//                                 list.add(nums[i]);
//                                 list.add(nums[j]);
//                                 list.add(nums[m]);
//                                 list.add(nums[n]);
//                                 set.add(list);
//                             }
//                         }
//                     }
//                 }
//             }

        //Partically work
        // Map<Integer, List<Integer>> first = new HashMap();
        // for(int i=0; i<len-3; i++) {
        //     for(int j=i+1; j<len-2; j++) {
        //         List<Integer> value = new ArrayList();
        //         value.add(i);
        //         value.add(j);
        //         first.put(nums[i] + nums[j], value);
        //     }
        // }

        Map<Integer, List<List<Integer>>> first = new HashMap();
        List<List<Integer>> value = new ArrayList();

        for(int i=0; i<len-3; i++) {
            for(int j=i+1; j<len-2; j++) {
                int key = nums[i] + nums[j];
                List<List<Integer>> v = first.get(key);
                if(v != null) {
                    List<Integer> newSubL = new ArrayList();
                    newSubL.add(nums[i]);
                    newSubL.add(nums[j]);
                    v.add(newSubL);
                    first.put(key, v);
                } else {
                    List<List<Integer>> newL = new ArrayList();
                    List<Integer> newSubL = new ArrayList();
                    newSubL.add(nums[i]);
                    newSubL.add(nums[j]);
                    newL.add(newSubL);
                    first.put(key, newL);
                }

            }
        }

        for(int i=2; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                int newTarget = target - nums[i] -nums[j];
                List<List<Integer>> l1 = first.get(newTarget);
                if(l1 != null) {
                    for(List<Integer> l : l1) {
                        if(l != null && l.get(1) < i) {
                            List<Integer> list = new ArrayList();
                            list.add(nums[l.get(0)]);
                            list.add(nums[l.get(1)]);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            set.add(list);
                        }
                    }
                }
            }
        }

        for(List<Integer> list: set) {
            lists.add(list);
        }
        return lists;
    }
}
