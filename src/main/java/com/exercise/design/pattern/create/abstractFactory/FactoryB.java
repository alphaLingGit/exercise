package com.exercise.design.pattern.create.abstractFactory;

public class FactoryB extends Factory{
    @Override
    public Product ManufactureContainer() {
        return new ContainerProductB();
    }

    @Override
    public Product ManufactureMould() {
        return new MouldProductB();
    }
}
