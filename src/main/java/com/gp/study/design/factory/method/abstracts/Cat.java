package com.gp.study.design.factory.method.abstracts;


public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}