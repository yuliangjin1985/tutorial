package com.yuliang.tutorial.leetcode.easy;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/11/2.
 *
 * @description：
 *
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

 How to check whether an integer is overflow after one operation?
 Reverse the operation and check the result with the original integer.
 */
public class IntegerReverse {
  public static void main(String[] args) {
    System.out.println(-98%10);
    System.out.println(reverseInteger(-98));
    System.out.println(Math.pow(2, 16) == 2<<15);
    System.out.println(2<<15);
    System.out.println(Math.pow(2l, 30));
    System.out.println(Math.pow(2,0));
    short a = 2;
    System.out.println(a<<1);
    System.out.println(a<<8);
    System.out.println(Integer.bitCount(1<<5));
    System.out.println(Integer.bitCount(-25));
    System.out.println(Integer.bitCount(25));
    System.out.println(Integer.bitCount(-16));//补码的1的个数
    System.out.println(Integer.bitCount(15));
  }

  private static int reverseInteger(int i) {
    int result = 0;
    while (i != 0) {
      int temp = i % 10;
      int newResult = result * 10 + temp;
      if((newResult-temp) / 10 != result) return 0;
      i = i/10;
      result = newResult;
    }
    return result;
  }
}
