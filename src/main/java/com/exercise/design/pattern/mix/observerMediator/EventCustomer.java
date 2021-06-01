package com.exercise.design.pattern.mix.observerMediator;

import java.util.Vector;

public abstract class EventCustomer {

    private Vector<ProductEventType> vector = new Vector<>();

    public EventCustomer(ProductEventType type) {
        vector.add(type);
    }

    public void addEventType(ProductEventType type) {
        vector.add(type);
    }

    public Vector<ProductEventType> getCustomType() {
        return vector;
    }

    public abstract void exec(ProductEvent event);
}
