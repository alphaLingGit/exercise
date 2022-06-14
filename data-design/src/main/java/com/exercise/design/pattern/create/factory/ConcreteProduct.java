package com.exercise.design.pattern.create.factory;

public class ConcreteProduct implements Product {
    @Override
    public void method1() {
        System.out.println("this is method1");
    }

    @Override
    public void method2() {
        System.out.println("this is method2");
    }
}
