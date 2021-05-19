package com.exercise.design.pattern.create.abstractFactory;

public class FactoryA extends Factory{
    @Override
    public Product ManufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public Product ManufactureMould() {
        return new MouldProductA();
    }
}
