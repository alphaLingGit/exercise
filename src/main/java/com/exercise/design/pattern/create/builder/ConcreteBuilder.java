package com.exercise.design.pattern.create.builder;

public class ConcreteBuilder extends Builder {

    private final Product product;

    public ConcreteBuilder(Product product) {
        this.product = product;
    }

    public void buildPartA() {
    }

    public void buildPartB() {
    }

    public void buildPartC() {
    }

    @Override
    public Product buildProduct() {
        return this.product;
    }

}
