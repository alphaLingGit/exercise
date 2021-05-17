package com.exercise.design.pattern.create.factory.simple;

public class CircleShape implements Shape{

    public CircleShape() {
    }

    @Override
    public void draw() {
        System.out.println("CircleShape");
    }
}
