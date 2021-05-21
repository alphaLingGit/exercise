package com.exercise.design.pattern.create.prototype;

public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public void operation(Prototype prototype) {
        Prototype copyPrototype = prototype.clone();
    }
}
