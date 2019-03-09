package com.gp.study.design.singleton.hunger;

/**
 * 饿汉式单例
 */
public class HungerSingleton {

    private HungerSingleton(){}

    private static final HungerSingleton INSTANCE = new HungerSingleton();

    public static HungerSingleton getInstance(){
        return INSTANCE;
    }
}
