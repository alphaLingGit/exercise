package com.exercise.design.pattern.behavior.visitor;

public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElement1 element1) {
        element1.operation();
    }

    @Override
    public void visit(ConcreteElement2 element2) {
        element2.operation();
    }
}
