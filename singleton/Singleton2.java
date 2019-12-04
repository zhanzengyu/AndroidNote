package com.nesger.helloworld;

/**
 * Created by nesger.zhan on 2016/11/11.
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 instance ;

    public static synchronized Singleton2 getInstance() {
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
