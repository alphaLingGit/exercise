package com.exercise.design.pattern.create.factory;

public class PngReader implements Reader {
    @Override
    public void read() {
        System.out.println("read png");
    }
}
