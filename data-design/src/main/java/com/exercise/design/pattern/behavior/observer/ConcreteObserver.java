package com.exercise.design.pattern.behavior.observer;

public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("收到通知，并进行处理！");
    }
}
