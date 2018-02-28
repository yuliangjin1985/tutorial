package com.yuliang.tutorial.leetcode.easy;

public class Palindromic {
    public static void main(String[] args) {
        System.out.println(isPalindromic("aba"));
        System.out.println(isPalindromic("aba"));
        System.out.println(isPalindromic("aba"));
        System.out.println(isPalindromic("aba"));
        System.out.println(isPalindromic("aba"));
        System.out.println(isPalindromic("aba"));
    }

    private static boolean isPalindromic(String s) {
        int len = s.length();
        int mid;
        if(len % 2 == 0) {
            mid = len / 2 + 1;
        }
        return false;
    }
}
