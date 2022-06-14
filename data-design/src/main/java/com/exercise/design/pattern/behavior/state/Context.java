package com.exercise.design.pattern.behavior.state;

/**
 * 环境
 */
public class Context {

    public static State STATE1 = new ConcreteState1();
    public static State STATE2 = new ConcreteState2();

    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        currentState.setContext(this);
    }

    public void handle1() {
        setCurrentState(STATE1);
        currentState.handle();
    }

    public void handle2() {
        setCurrentState(STATE2);
        currentState.handle();
    }
}
