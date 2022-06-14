package com.exercise.design.pattern.behavior.interpreter;

/**
 * 抽象表达式
 */
public abstract class AbstractExpression {

    /**
     * 解析方法
     */
    public abstract Object interpreter(Context context);
}
