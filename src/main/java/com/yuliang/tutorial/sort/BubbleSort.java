package com.yuliang.tutorial.sort;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/24.
 *
 * @description
 */
public class BubbleSort {
  public static void bubbleSort() {
    int[] integers = {12, 34, 45, 112, 23};
    int length = integers.length;
    for(int j=0; j<length-1; j++) {
      for(int i=0; i<length-j-1; i++) {
        if (integers[i] > integers[i + 1]) {
          int temp = integers[i];
          integers[i] = integers[i + 1];
          integers[i + 1] = temp;
        }
      }
    }
    for (int integer : integers) {
      System.out.println(integer);
    }
  }

  public static void main(String[] args) {
    bubbleSort();
  }
}
