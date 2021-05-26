package com.exercise.design.pattern.structure.decorator;

/**
 * 具体装饰
  */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    private void method() {
        System.out.println("装饰");
    }

    @Override
    public void operation() {
        method();
        super.operation();
    }
}
