package com.yuliang.tutorial.sort;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/11/4.
 *
 * @description quickSort2 才是最好理解的快速排序
 */
public class QuickSort {
  public static void main(String[] args) {
//    int[] nums  = new int[] {23, 3,4,5,12};
    int[] nums  = new int[] {23, 3,4,5,12,23,344,22,23,3,2,400};
    quick(nums,1,nums.length-1);
    for (int num : nums) {
      System.out.println(num);
    }
//
//    int[] a = new int[] {2,1,4};
//    System.out.println(maxProfit(a));

  }

  public static int maxProfit(int[] p) {
    int max = 0;
    int l = p.length;
    for(int i=1; i<l; i++) {
      if(p[i]>=p[i-1]) max += p[i]-p[i-1];
    }
    return max;
  }

  public static void quickSort2(int[] nums, int low, int high) {
    if(high<=low) return;
    int pivot = nums[high];
    int wall = low;

    for(int i=low, len=nums.length;i<len-1;i++) {
      if(nums[i] < pivot) {
        int temp = nums[wall];
        nums[wall] = nums[i];
        nums[i] = temp;
        wall++;
      }
    }
    int temp = nums[wall];
    nums[wall] = pivot;
    nums[high] = temp;

    quickSort2(nums, low, wall-1);
    quickSort2(nums, wall+1, high);
  }

  public static void quick(int[] nums, int low, int high) {
    if(low > high) return;

    int wall = low;
    int pivot = nums[high];

    for(int i=low, len=nums.length; i<len-1; i++) {
      if (nums[i] < pivot) {
        int temp = nums[i];
        nums[i] = nums[wall];
        nums[wall] = temp;
        wall++;
      }
    }

    int temp = nums[wall];
    nums[wall] = pivot;
    nums[high] = temp;

    quick(nums, low, wall-1);
    quick(nums, wall+1, high);
  }

  public static void quickSort(int[] nums, int low, int high) {
    if(nums.length<1 || low>high) return;
    int pivot = nums[(low+high)>>1];
    int i=low, j=high;
    while(i<=j) {
      while(nums[i]<pivot) {
        i++;
      }
      while(nums[j] > pivot) {
        j--;
      }

      if(i<j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        j--;
        i++;
      }
    }

    if(low<j) quickSort(nums,low,j);
    if(high>i) quickSort(nums,i,high);
  }

  public static void quickSort1(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;

    if (low >= high)
      return;

    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j)
      quickSort(arr, low, j);

    if (high > i)
      quickSort(arr, i, high);
  }

}
