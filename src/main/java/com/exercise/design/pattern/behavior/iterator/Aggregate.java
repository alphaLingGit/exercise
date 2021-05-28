package com.exercise.design.pattern.behavior.iterator;

/**
 * 抽象聚集
 */
public interface Aggregate {

    void add(Object obj);

    Iterator creatIterator();
}
