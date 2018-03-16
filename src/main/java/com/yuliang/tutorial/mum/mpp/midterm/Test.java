package com.yuliang.tutorial.mum.mpp.midterm;

public class Test {
    public static void main(String[] args) {
        int i=0;
        String name = "hello";
        String sql = "insert into employee values(" + i + ","  + "'" + name + "')";
        System.out.println(sql);
    }
}
