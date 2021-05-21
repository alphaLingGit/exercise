package com.exercise.design.pattern.create.prototype;

public class ConcretePrototype2 implements Prototype{
    @Override
    public Prototype clone() {
        return new ConcretePrototype2();
    }
}
