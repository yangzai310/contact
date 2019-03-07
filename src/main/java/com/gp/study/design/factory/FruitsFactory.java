package com.gp.study.design.factory;


public class FruitsFactory {

    private FruitsFactory(){}

    public static Fruits creator(String name) {
        Fruits fruits = null;
        switch (name){
            case "apple":fruits = new Apple();
                break;
            case "orange":fruits = new Orange();
                break;
        }
        return fruits;
    }
}