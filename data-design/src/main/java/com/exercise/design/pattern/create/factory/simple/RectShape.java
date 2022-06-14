package com.exercise.design.pattern.create.factory.simple;

public class RectShape implements Shape {

    public RectShape() {
    }

    @Override
    public void draw() {
        System.out.println("RectShape");
    }
}
