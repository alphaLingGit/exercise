package com.exercise.design.pattern.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 具体主题
 */
public class ConcreteSubject implements Subject{

    private final Vector<Observer> observers = new Vector<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * 返回观察者集合的Enumeration对象
     */
    public Enumeration<Observer> observers() {
        return observers.elements();
    }

    /**
     * 业务方法，改变状态
     */
    public void change() {
        notifyObserver();
    }
}
