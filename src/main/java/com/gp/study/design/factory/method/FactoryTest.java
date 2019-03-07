package com.gp.study.design.factory.method;


public  class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory a = new AppleFactory();
        Fruits creator = a.creator();
        creator.taste();
    }

}