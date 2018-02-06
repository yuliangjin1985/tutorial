package com.yuliang.tutorial.basic.numbers;

import java.util.Arrays;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/11/6.
 *
 * @description
 */
public class Fabonacci {

  public static void main(String[] args) {
    for(int i=0; i<10; i++) {
      System.out.println(fabonacciIteration(i));
    }

    System.out.println(findSecondLargest(new int[] {1,2,4,5,23}));
    System.out.println(findSecondLargest2(new int[] {1,2,4,5,23}));
    System.out.println(findSecondLargest(new int[] {1,47,4,5,23}));
    System.out.println(findSecondLargest2(new int[] {1,47,4,5,23}));
  }

  public static int findSecondLargest(int[] nums) {
    int l = nums.length;
    if(l<2) return 0;
    int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;

    for(int i=0;i<l;i++) {
      if(nums[i] > l1) {
        l2 = l1;
        l1 = nums[i];
      } else if(nums[i] > l2) l2=nums[i];
    }
    System.out.println("max1 " + l1);
    System.out.println("max2 " + l2);
    return l2;
  }

  public static int findSecondLargest2(int[] nums) {
    int l = nums.length;
    if(l<2) return 0;

    for(int i=0;i<2;i++) {
      for(int j=0; j<l-i-1; j++) {
        if(nums[j] > nums[j+1]) {
          int temp = nums[j+1];
          nums[j+1] = nums[j];
          nums[j] = temp;
        }
      }
    }

    return nums[l-2];
  }

  private static int fabonacciIteration(int n) {

    int ret = 0;

    if(n==0 || n==1) return 1;
    int first = 1;
    int second = 1;


    for(int i=2; i<=n;i++) {
      ret = first + second;
      first = second;
      second = ret;
    }

    return ret;
  }
}
