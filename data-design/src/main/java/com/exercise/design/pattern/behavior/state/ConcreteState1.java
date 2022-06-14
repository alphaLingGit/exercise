package com.exercise.design.pattern.behavior.state;

/**
 * 具体状态1
 */
public class ConcreteState1 extends State{
    @Override
    public void handle() {
        System.out.println("行为1的逻辑处理");
    }
}
