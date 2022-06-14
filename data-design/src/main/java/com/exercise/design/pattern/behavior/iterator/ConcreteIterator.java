package com.exercise.design.pattern.behavior.iterator;

/**
 * 具体迭代器
 */
public class ConcreteIterator implements Iterator {

    private final ConcreteAggregate aggregate;

    private int index;

    private final int size;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        index = 0;
        size = aggregate.size();
    }

    @Override
    public Object next() {
        if(hasNext()) {
            return aggregate.getElement(index++);
        }else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }
}
