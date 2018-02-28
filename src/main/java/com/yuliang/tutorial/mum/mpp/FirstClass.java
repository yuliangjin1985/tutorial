package com.yuliang.tutorial.mum.mpp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstClass {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Computer", 400d),
                new Product(2, "Mac", 500d)
                );
        String xmlData = "<products>\n" + products.stream()
                .map(p -> p.toXMLString())
                .collect(Collectors.joining());
        System.out.println(xmlData + "</products>");
    }
}
