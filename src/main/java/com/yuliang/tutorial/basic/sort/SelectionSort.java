package com.yuliang.tutorial.sort;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/24.
 *
 * @description
 */
public class SelectionSort {
  public static void selectionSort() {
    int[] ints = {23, 11, 20, 2, -9, 200, 19, 9};
    int length = ints.length;

    for(int i=1; i<length; i++) {//先把第1个数当成最小的，然后每次遍历一遍，都找出这次遍历的最小数，并把它放到合适的位置
      int min = i -1;
      for(int j=i; j<length; j++) {//找出最小的位置输的坐标，即min的值
        if (ints[j] < ints[min]) {
          min = j;
        }
      }

      if (min > i - 1) {
        int temp = ints[i - 1];
        ints[i - 1] = ints[min];
        ints[min] = temp;
      }
    }

    for (int i : ints) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    selectionSort();
  }
}
