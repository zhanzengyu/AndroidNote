package com.nesger.helloworld;

/**
 * Created by nesger.zhan on 2016/11/11.
 */
public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

}
