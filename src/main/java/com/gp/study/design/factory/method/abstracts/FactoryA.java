package com.gp.study.design.factory.method.abstracts;


/**
 * Author:   wangchunyang
 * Description: 工厂A
 */
public class FactoryA implements AbstractFactory {

    @Override
    public Fruits creatorFruits() {
        return new Apple();
    }

    @Override
    public Animal creatorAnimals() {
        return new Cat();
    }
}