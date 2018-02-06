package com.yuliang.tutorial.leetcode;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/30.
 *
 * @description
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

  public static void main(String[] args) {
    int[] nums = {0,0,0,5,6,9};
    System.out.println(threeSumClosest(nums, 6));
  }

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[nums.length-1];
    for(int i=0;i<nums.length-2;i++) {
      if(i==0 || nums[i] != nums[i-1]) {
        int low = i+1, high = nums.length-1;
        while (low < high) {
          int sum = nums[i] + nums[low] + nums[high];
          if(sum < target) {
            low++;
          } else high--;
          if(Math.abs(sum - target) < Math.abs(result - target)) {
            result = sum;
          }
        }
      }
    }
    return result;
  }
}
