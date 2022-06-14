package com.exercise.design.pattern.behavior.mediator;

/**
 * 抽象同事类
 */
public abstract class Colleague {

    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 抽象行动方法
     */
    public abstract void action();

    public void change() {
        mediator.colleagueChanged();
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
