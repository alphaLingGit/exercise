package com.exercise.design.pattern.structure.proxy;

/**
 * 代理主题
 */
public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        beforeRequest();
        subject.request();
        afterRequest();
    }

    private void beforeRequest() {

    }

    private void afterRequest() {

    }
}
