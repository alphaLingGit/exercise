package com.exercise.design.pattern.create.factory.simple;

public class TriangleShape implements Shape {

    public TriangleShape() {
    }

    @Override
    public void draw() {
        System.out.println("TriangleShape");
    }
}
