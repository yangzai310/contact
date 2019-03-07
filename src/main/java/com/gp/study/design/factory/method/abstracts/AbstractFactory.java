package com.gp.study.design.factory.method.abstracts;


/**
 * @author wcy
 * @DescripTion 工厂方法模式 -- 抽象工厂
 **/
public interface AbstractFactory {

    Fruits creatorFruits();

    Animal creatorAnimals();
}
