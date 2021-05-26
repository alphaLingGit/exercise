package com.exercise.design.pattern.structure.bridge;

/**
 * 抽象化角色
 */
public abstract class Abstraction {

    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        implementor.operationImp();
    }
}
