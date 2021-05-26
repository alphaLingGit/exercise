package com.exercise.design.pattern.structure.flyweight;

/**
 * 具体享元
 */
public class ConcreteFlyweight implements Flyweight{

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("内部状态：" + intrinsicState + "，外部状态：" + extrinsicState);
    }
}
