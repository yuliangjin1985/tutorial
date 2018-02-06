package com.yuliang.tutorial.basic.collections;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * Created by 靳玉亮 (530367387@qq.com) on 17/11/1.
 *
 * @description
 */
public class VectorExample {
  public static void main(String[] args) throws NoSuchFieldException {
    Vector<Integer> vector = new Vector<>();
    Field modCount = vector.getClass().getField("modCount");
    System.out.println(modCount);
  }
}
