package com.exercise.design.pattern.behavior.chainOfResponsibility;

/**
 * 抽象处理者
 */
public abstract class Handler {


    private Handler successor;

    public abstract void handleRequest();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
