package com.exercise.design.pattern.create.factory;

public class JpgReader implements Reader {
    @Override
    public void read() {
        System.out.print("read jpg");
    }
}
