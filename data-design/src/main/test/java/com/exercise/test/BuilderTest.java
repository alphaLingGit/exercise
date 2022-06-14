package com.exercise.test;

import com.exercise.design.pattern.create.builder.Builder;
import com.exercise.design.pattern.create.builder.ConcreteBuilder;
import com.exercise.design.pattern.create.builder.Director;
import com.exercise.design.pattern.create.builder.Product;

public class BuilderTest {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder(new Product());
        Director director = new Director(builder);
        Product product = director.constructorProduct();
    }

}
