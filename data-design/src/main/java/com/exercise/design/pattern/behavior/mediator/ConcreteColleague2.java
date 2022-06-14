package com.exercise.design.pattern.behavior.mediator;

public class ConcreteColleague2 extends Colleague{

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("同事2行动方法");
    }
}
