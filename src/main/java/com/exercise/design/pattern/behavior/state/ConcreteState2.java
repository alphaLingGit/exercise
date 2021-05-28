package com.exercise.design.pattern.behavior.state;

/**
 * 具体状态2
 */
public class ConcreteState2 extends State{
    @Override
    public void handle() {
        System.out.println("行为2的逻辑处理");
    }
}
