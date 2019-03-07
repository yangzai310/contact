package com.gp.study.design.factory.method;


public class AppleFactory implements AbstractFactory {

    @Override
    public Fruits creator() {
        return new Apple();
    }
}