package com.exercise.test;

import com.exercise.design.pattern.create.abstractFactory.*;
import com.exercise.design.pattern.create.factory.ConcreteCreator;
import com.exercise.design.pattern.create.factory.ConcreteProduct;
import com.exercise.design.pattern.create.factory.Product;
import com.exercise.design.pattern.create.factory.simple.Shape;
import com.exercise.design.pattern.create.factory.simple.ShapeSimpleFactory;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void simpleFactoryTest() {
        Shape circle = ShapeSimpleFactory.getShape("circle");
        Shape rect = ShapeSimpleFactory.getShape("rect");
        Shape triangle = ShapeSimpleFactory.getShape("triangle");
        circle.draw();
        rect.draw();
        triangle.draw();
    }

    @Test
    public void factoryMethodTest() {
        Product factory = new ConcreteCreator().factory(ConcreteProduct.class);
        factory.method1();
        factory.method2();
    }

    @Test
    public void abstractFactoryTest() {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA1 = factory1.factoryA();
        ProductB productB1 = factory1.factoryB();
        ProductA productA2 = factory2.factoryA();
        ProductB productB2 = factory2.factoryB();
        productA1.method1();
        productB1.method1();
        productA2.method1();
        productB2.method1();
        productA1.method2();
        productB1.method2();
        productA2.method2();
        productB2.method2();
    }

}
