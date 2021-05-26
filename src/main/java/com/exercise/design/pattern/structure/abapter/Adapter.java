package com.exercise.design.pattern.structure.abapter;

/**
 * 适配器
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.specificRequest();
    }
}
