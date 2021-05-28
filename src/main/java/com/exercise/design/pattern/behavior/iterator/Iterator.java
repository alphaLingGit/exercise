package com.exercise.design.pattern.behavior.iterator;

/**
 * 抽象迭代器
 */
public interface Iterator {

    Object next();

    boolean hasNext();
}
