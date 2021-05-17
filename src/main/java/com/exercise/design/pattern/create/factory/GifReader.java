package com.exercise.design.pattern.create.factory;

public class GifReader implements Reader {
    @Override
    public void read() {
        System.out.println("read gif");
    }
}
