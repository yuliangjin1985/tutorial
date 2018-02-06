package com.yuliang.tutorial.basic.string;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/31.
 *
 * @description
 */
public class StringReverse {
  public static void main(String[] args) {
    String str = "0988999e9iriwer";
    System.out.println(reverse(str));
    System.out.println(reverseRecursive(str));
    System.out.println(reverseByIteration(str));
  }

  //using iteration
  private static String reverseByIteration(String str) {
    char[] chars = str.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=chars.length-1;i>=0;i--) {
      stringBuilder.append(chars[i]);
    }
    return stringBuilder.toString();
  }

  //using recursive method
  private static String reverseRecursive(String str) {
    if(str.length() == 1) return str;
    return reverseRecursive(str.substring(1)) + str.charAt(0);
  }

  //using jdk method of StringBuffer
  public static String reverse(String string) {
    return new StringBuffer(string).reverse().toString();
  }
}
