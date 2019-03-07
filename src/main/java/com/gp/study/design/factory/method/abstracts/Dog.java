package com.gp.study.design.factory.method.abstracts;


public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}