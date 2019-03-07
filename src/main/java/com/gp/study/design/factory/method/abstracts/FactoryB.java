package com.gp.study.design.factory.method.abstracts;


/**
 * Author:   wangchunyang
 * Description: 工厂B
 */
public class FactoryB implements AbstractFactory {

    @Override
    public Fruits creatorFruits() {
        return new Orange();
    }

    @Override
    public Animal creatorAnimals() {
        return new Dog();
    }
}