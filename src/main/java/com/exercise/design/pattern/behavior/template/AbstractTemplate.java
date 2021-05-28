package com.exercise.design.pattern.behavior.template;

public abstract class AbstractTemplate {

    /**
     * 基本方法
     */
    protected abstract void operation();

    /**
     * 模板方法
     */
    public void templateMethod() {
        operation();
    }
}
