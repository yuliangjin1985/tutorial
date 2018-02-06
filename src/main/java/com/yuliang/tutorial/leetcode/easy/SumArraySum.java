package com.yuliang.tutorial.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/11/2.
 *
 * @description
 */
public class SumArraySum {

  public static void main(String[] args) {
    int[] nums = new int[] {1,1,1};
//    int[] nums = new int[] {23,34,3434,33};
    System.out.println(subarraySum(nums, 2));
  }

  /**
   * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
   * @param nums
   * @param k
   * @return
   */

    public static int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap();
      int sum = 0;
      int num = 0;
      map.put(0, 1);
      for(int i=0, length=nums.length; i<length; i++) {
        sum += nums[i];
        if(map.containsKey(sum - k)) {
          num = num + map.get(sum -k);
        }
        map.put(sum, map.getOrDefault((sum), 0) +1);
      }

      return num;

    }
}
