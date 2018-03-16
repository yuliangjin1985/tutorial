package com.yuliang.tutorial.mum.mpp.lesson8.onclass;

import com.yuliang.tutorial.mum.mpp.lesson7.assignment.labs.prob1.partD.MyInterface;

import java.util.Objects;
import java.util.function.Supplier;

public class MyClass {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyClass(String name) {

        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(name, myClass.name);
    }

    public boolean myMethod(MyClass ml) {
//        if(this == ml) return true;
//        if(this.equals(ml)) return true;
//        return false;

//        ml -> this::equals;
        return false;

    }

    public static void main(String[] args) {
        Supplier supplier = () -> Math.random();
        System.out.println(supplier.get());

        MySupplier mySupplier = new MySupplier();
        System.out.println(mySupplier.get());

    }

    static class MySupplier implements Supplier<java.lang.Double> {
        public java.lang.Double get() {
            return java.lang.Double.valueOf(Math.random());
        }
    }

}
