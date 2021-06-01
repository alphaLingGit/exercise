package com.exercise.design.pattern.mix.observerMediator;

import java.util.Observable;

public class ProductEvent extends Observable {

    private Product source;
    private ProductEventType type;

    public ProductEvent(Product product) {
        this(product, ProductEventType.NEW_PRODUCT);
    }

    public ProductEvent(Product source, ProductEventType type) {
        this.source = source;
        this.type = type;
    }

    public Product getSource() {
        return source;
    }

    public ProductEventType getType() {
        return type;
    }

    private void notifyEventDispatch() {
        super.addObserver(EventDispatch.getEventDispatch());
        super.setChanged();
        super.notifyObservers(source);
    }
}
