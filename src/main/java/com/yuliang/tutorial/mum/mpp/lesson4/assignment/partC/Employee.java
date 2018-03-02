package com.yuliang.tutorial.mum.mpp.lesson4.assignment.partC;

public abstract class Employee {

    private String employeeId;

    public Paycheck calcCompensation(int month,int year) {
        double grossPay = this.calcGrossPay(month, year);
        return new Paycheck(grossPay, TaxEnum.FICA.getValue() * grossPay, grossPay*TaxEnum.STATE_TAX.getValue(),
                grossPay*TaxEnum.LOCAL_TAX.getValue(), grossPay*TaxEnum.MEDICARE.getValue(),
                grossPay*TaxEnum.SOCIAL_SECURITY.getValue());
    }

    public abstract double calcGrossPay(int month, int year);
}
