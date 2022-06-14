package com.exercise.design.pattern.behavior.mediator;

/**
 * 具体中介者
 */
public class ConcreteMidator extends Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void createConcreteMediator() {
        colleague1 = new ConcreteColleague1(this);
        colleague2 = new ConcreteColleague2(this);
    }

    @Override
    public void colleagueChanged() {
        colleague1.action();
        colleague2.action();
    }

    public ConcreteColleague1 getColleague1() {
        return colleague1;
    }

    public ConcreteColleague2 getColleague2() {
        return colleague2;
    }
}
