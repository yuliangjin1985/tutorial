package com.yuliang.tutorial;

import java.util.HashSet;
/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/27.
 *
 * @description
 */
public class ForMUM {

  public static void main(String[] args) {
    int[] inputs = {4, 1, 2, 3};
//    int[] inputs = {1, 1, 0};
//    int[] inputs = {1, 2, 3, 4, 5, 5, 23,-9,22, 233};
    System.out.println(new ForMUM().getSecondLargest(inputs));
    System.out.println(new ForMUM().get2ndMax(inputs));
    System.out.println(new ForMUM().get2ndMin(inputs));
    System.out.println(new ForMUM().getIndexOfLargest(inputs));
    System.out.println(new ForMUM().getOddMinusEven(inputs));
    System.out.println(new ForMUM().getScore());
  }

  public int getSecondLargest(int[] input) {
    //transform to a set, so each number is single
    HashSet<Integer> integers = new HashSet<>();
    for (int i : input) {
      integers.add(i);
    }

    if (integers.size() < 2) {
      return -1;
    }

    int[] ints = new int[integers.size()];

    int k = 0;
    for (int i: integers) {
      ints[k++] = i;
    }


    //selection sort to get the second largest
    for(int i=0; i<2; i++) {
      int max = i;
      for(int j=i; j<ints.length -1 ; j++) {
        if (ints[j + 1] > ints[max]) {
          max = j + 1;
        }
      }

      if (max > i) {
        int temp = ints[max];
        ints[max] = ints[i];
        ints[i] = temp;
      }
    }

    return ints[1];
  }

  public int get2ndMax(int[] input) {
    int largest, secondLargest;
    largest = secondLargest = Integer.MIN_VALUE;

    for(int i=0; i<input.length; i++) {

      if (input[i] > largest) {
        secondLargest = largest;
        largest = input[i];
      } else if (input[i] > secondLargest && input[i] != largest) {
        secondLargest = input[i];
      }
    }

    if (secondLargest != largest) {
      return secondLargest;
    }
    return -1;
  }

  //get the second smallest number
  public int get2ndMin(int[] input) {

    int smallest = Integer.MAX_VALUE;
    int secondSmallest = smallest;

    for(int i=0; i<input.length; i++) {
      if (input[i] < smallest) {
        secondSmallest = smallest;
        smallest = input[i];
      } else if (input[i] < secondSmallest && input[i] != smallest) {
        secondSmallest = input[i];
      }
    }

    return secondSmallest;
  }

  public int getIndexOfLargest(int[] inputs) {
    int max = 0;

    for(int i=0; i<inputs.length; i++) {
      if (inputs[i] > inputs[max]) {
        max = i;
      }
    }

    return max;
  }

  public int getOddMinusEven(int[] inputs) {
    int result = 0;
    for(int i=0; i<inputs.length; i++) {
      int flag = 1;
      if (inputs[i] % 2 == 0) {
        flag = -1;
      }
      result = result + flag * inputs[i];
    }

    return result;
  }

  public double getScore() {

    double credits =
            2 +
            1 +
            4 +
            5 +
            2 +
            2 +
            4 +
            1 +
            4 +
            4 +
            2 +
            4 +
            4 +
            1 +
            4 +
            5 +
            3 +
            2 +
            1.5 +
            1 +
            0.5 +
            4 +
        3 +
        2 +
        4 +
        1 +
        3.5 +
        1 +
        1 +
        2 +
        4 +
        4 +
        1 +
        2 +
        5 +
        1 +
        4 +
        4 +
        0.5 +
        0.5 +
        5 +
        3 +
        5 +
        3 +
        3 +
        1 +
        4 +
        2 +
        3 +
        2 +
        2 +
        0.5 +
        3 +
        3 +
        8 +
        1 +
        0.5 +
        4;
    double total =
        85 * 2 +
        83 * 1 +
        90 * 4 +
        71 * 5 +
        64 * 2 +
        82 * 2 +
        72 * 4 +
        85 * 1 +
        60 * 4 +
        73 * 4 +
        86 * 2 +
        96 * 4 +
        60 * 4 +
        82 * 1 +
        63 * 4 +
        70 * 5 +
        73 * 3 +
        85 * 2 +
        79 * 1.5 +
        90 * 1 +
        81 * 0.5 +
        84 * 4 +
        75 * 3 +
        84 * 2 +
        91 * 4 +
        80 * 1 +
        80 * 3.5 +
        92 * 1 +
        79 * 1 +
        98 * 2 +
        93 * 4 +
        87 * 4 +
        85 * 1 +
        77 * 2 +
        82 * 5 +
        85 * 1 +
        80 * 4 +
        80 * 4 +
        84 * 0.5 +
        82 * 0.5 +
        89 * 5 +
        84 * 3 +
        84 * 5 +
        83 * 3 +
        86 * 3 +
        95 * 1 +
        86 * 4 +
        86 * 2 +
        93 * 3 +
        76 * 2 +
        91 * 2 +
        89 * 0.5 +
        90 * 3 +
        84 * 3 +
        83 * 8 +
        81 * 1 +
        86 * 0.5 +
        88 * 4;

    System.out.println(credits);

    return total / credits;
  }
}
