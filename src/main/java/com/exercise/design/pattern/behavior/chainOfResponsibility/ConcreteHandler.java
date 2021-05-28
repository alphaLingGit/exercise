package com.exercise.design.pattern.behavior.chainOfResponsibility;

public class ConcreteHandler extends Handler {
    @Override
    public void handleRequest() {
        Handler successor = getSuccessor();
        if (successor == null) {
            System.out.println("处理请求");
        } else {
            System.out.println("请求传递给" + successor);
            successor.handleRequest();
        }
    }
}
