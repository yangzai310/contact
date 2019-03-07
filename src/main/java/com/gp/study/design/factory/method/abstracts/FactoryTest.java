package com.gp.study.design.factory.method.abstracts;


public  class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory a = new FactoryA();
        Animal animal = a.creatorAnimals();
        Fruits fruits = a.creatorFruits();
        animal.eat();
        fruits.taste();
    }

}