package com.nesger.helloworld;

/**
 * Created by nesger.zhan on 2016/11/11.
 */
public class Singleton3 {

    private Singleton3() {
    }

    private volatile static Singleton3 instance ;

    public static Singleton3 getInstance() {
        if (instance == null){
            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}
