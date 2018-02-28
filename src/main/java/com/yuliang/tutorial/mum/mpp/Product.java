package com.yuliang.tutorial.mum.mpp;

public class Product {
    private final int productId;
    private final String name;
    private final double unitPrice;

    public Product(int productId, String name, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String toXMLString() {
        return String.format(" <product> id=\"%d\" name=\"%s\" price=\"%f\" />\n", productId, name, unitPrice);
    }
}
