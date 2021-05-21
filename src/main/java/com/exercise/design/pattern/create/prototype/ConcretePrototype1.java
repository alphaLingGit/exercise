package com.exercise.design.pattern.create.prototype;

public class ConcretePrototype1 implements Prototype{
    @Override
    public Prototype clone() {
        return new ConcretePrototype1();
    }
}
