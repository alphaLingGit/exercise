package com.exercise.design.pattern.create.factory;

public class ConcreteCreator implements Creator {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Product> T factory(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
