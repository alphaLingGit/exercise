package com.exercise.design.pattern.behavior.strategy;

/**
 * 环境(上下文)
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.strategyInterface();
    }
}
