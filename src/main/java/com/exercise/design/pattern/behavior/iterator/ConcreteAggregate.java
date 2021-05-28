package com.exercise.design.pattern.behavior.iterator;

import java.util.Vector;

public class ConcreteAggregate implements Aggregate{

    private final Vector<Object> vector = new Vector<>();

    @Override
    public void add(Object obj) {
        vector.add(obj);
    }

    @Override
    public Iterator creatIterator() {
        return new ConcreteIterator(this);
    }

    public Object getElement(int index) {
        if(index < vector.size()) {
            return vector.get(index);
        } else {
            return null;
        }
    }

    public int size() {
        return vector.size();
    }
}
