package com.exercise.design.pattern.behavior.memento;

/**
 * 发起人
 */
public class Originator {

    /**
     * 内部状态
     */
    private String state = "";

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        setState(memento.getState());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
