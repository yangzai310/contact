package com.gp.study.design.factory.method;


public class OrangeFactor implements AbstractFactory {

    @Override
    public Fruits creator() {
        return new Orange();
    }
}