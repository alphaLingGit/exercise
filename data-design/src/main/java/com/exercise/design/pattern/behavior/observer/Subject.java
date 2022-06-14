package com.exercise.design.pattern.behavior.observer;

/**
 * 抽象主题
 */
public interface Subject {

    /**
     * 登记一个新的观察者
     */
    void attach(Observer observer);

    /**
     * 删除一个登记过的观察者
     */
    void detach(Observer observer);

    /**
     * 通知所有登记过的观察者
     */
    void notifyObserver();
}
