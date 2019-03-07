package com.gp.study.design.factory;

public  class  FactoryTest {

    public static void main(String[] args) {
        Fruits creator = FruitsFactory.creator("orange");
        creator.taste();
    }

}