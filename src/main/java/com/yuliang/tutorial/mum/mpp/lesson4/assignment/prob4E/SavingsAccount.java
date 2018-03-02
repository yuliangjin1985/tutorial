package com.yuliang.tutorial.mum.mpp.lesson4.assignment.prob4E;

public class SavingAccount extends Account{

    private double interestRate;


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingAccount(String accountId, double balance, double interestRate) {
        super(accountId, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double computeUpdatedBalance() {
        return getBalance() * (1 + interestRate);
    }
}
