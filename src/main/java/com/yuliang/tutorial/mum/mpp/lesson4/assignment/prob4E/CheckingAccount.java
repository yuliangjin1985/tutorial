package com.yuliang.tutorial.mum.mpp.lesson4.assignment.prob4E;

public class CheckingAccount extends Account{

    private double monthlyFee;


    public CheckingAccount(String accountId, double monthlyFee, double balance) {
        super(accountId, balance);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public double computeUpdatedBalance() {
        return getBalance() - monthlyFee;
    }
}
