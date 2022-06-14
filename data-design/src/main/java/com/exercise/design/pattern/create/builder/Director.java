package com.exercise.design.pattern.create.builder;

public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product constructorProduct() {
        this.builder.buildPartA();
        this.builder.buildPartB();
        this.builder.buildPartC();
        return this.builder.buildProduct();
    }
}
