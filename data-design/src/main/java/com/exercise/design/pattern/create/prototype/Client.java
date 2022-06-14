package com.exercise.design.pattern.create.prototype;

public class Client {

    public void operation(Prototype example) {
        Prototype copyPrototype = example.clone();
    }
}
