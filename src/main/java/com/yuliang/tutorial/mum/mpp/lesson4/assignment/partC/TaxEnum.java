package com.yuliang.tutorial.mum.mpp.lesson4.assignment.partC;

public enum TaxEnum {
    FICA(0.23),
    STATE_TAX(0.05),
    LOCAL_TAX(0.01),
    MEDICARE(0.03),
    SOCIAL_SECURITY(0.075);

    public final double value;

    TaxEnum(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
