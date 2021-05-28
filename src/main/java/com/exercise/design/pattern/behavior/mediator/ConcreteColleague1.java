package com.exercise.design.pattern.behavior.mediator;

public class ConcreteColleague1 extends Colleague{

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("同事1行动方法");
    }
}
