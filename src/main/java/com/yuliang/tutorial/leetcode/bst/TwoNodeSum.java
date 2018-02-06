package com.yuliang.tutorial.leetcode.bst;

import java.util.HashSet;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/30.
 *
 * @description
 */
public class TwoNodeSum {

  public static void main(String[] args) {
  }
  public boolean findTarget(Node root, int k) {
    HashSet<Integer> set = new HashSet<>();
    return find(root, set, k);
  }

  private boolean find(Node root, HashSet<Integer> set, int k) {
    if(root == null) return false;
    int target = k - root.val;
    if(set.contains(target)) return true;
    set.add(root.val);
    return find(root.left, set, k) || find(root.right, set, k);
  }
}

class Node {
  public int val;
  public Node left, right;
  public Node(int val) {
    this.val = val;
  }
}
