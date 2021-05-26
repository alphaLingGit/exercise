package com.exercise.design.pattern.structure.bridge;

/**
 * 修正抽象化角色
 */
public class RefinedAbstraction extends Abstraction{

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
    }
}
