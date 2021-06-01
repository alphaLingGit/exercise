package com.exercise.design.pattern.mix.observerMediator;

public class Product implements Cloneable {

    private String name;
    private boolean canChange;

    public Product(ProductManager manager, String name) {
        if (manager.isCreateProduct()) {
            canChange = true;
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (canChange) {
            this.name = name;
        }
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
}
