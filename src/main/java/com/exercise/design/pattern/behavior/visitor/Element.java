package com.exercise.design.pattern.behavior.visitor;

/**
 * 抽象元素
 */
public abstract class Element {

    public abstract void accept(Visitor visitor);
}
