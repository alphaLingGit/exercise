package com.exercise.design.pattern.behavior.visitor;

/**
 * 抽象访问者
 */
public interface Visitor {

    void visit(ConcreteElement1 element1);

    void visit(ConcreteElement2 element2);
}
