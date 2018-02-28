package com.yuliang.tutorial.basic.stack;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        int num1 = 0;
        if (!s1.empty()) {
            num1 = num1 * 10 + s1.pop();
        }

        System.out.println(num1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();



        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int num1 = 0, num2 = 0;

        while(!s1.empty()) {
            num1 = num1 * 10 + s1.pop();
        }

        while(!s2.empty()) {
            num2 = num2 * 10 + s2.pop();
        }

        int num = num1 + num2;

        ListNode ret = null;
        ListNode tail = null;

        while(num != 0) {
            int n = num % 10;
            num = num / 10;
            ListNode node = new ListNode(n);
            if(ret == null) {
                ret = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return ret;
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      }
}
