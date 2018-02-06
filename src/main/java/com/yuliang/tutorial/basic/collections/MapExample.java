package com.yuliang.tutorial.basic.collections;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/10/27.
 *
 * @description
 */
public class MapExample {
  public static void main(String[] args) {
    TreeMap<Integer, String> integerStringTreeMap = new TreeMap<>();

    integerStringTreeMap.put(34, "hello");
    integerStringTreeMap.put(4, "four");
    integerStringTreeMap.put(6, "six");

    Iterator<Integer> iterator = integerStringTreeMap.keySet().iterator();

    while (iterator.hasNext()) {
      Integer next = iterator.next();
      System.out.println(next);
      System.out.println(integerStringTreeMap.get(next));
    }
  }
}
