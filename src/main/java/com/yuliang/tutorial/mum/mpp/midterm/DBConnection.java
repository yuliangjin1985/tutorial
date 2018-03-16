package com.yuliang.tutorial.mum.mpp.midterm;

public abstract class DBConnection {
    //A private constructor could stop this class being extended

    private int a;
    private DBConnection() {
    }

    public DBConnection(int a) {
        this.a = a;
    }

//    public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection(5);
//    }
}
