package com.exercise.design.pattern.behavior.interpreter;

import java.util.HashMap;

/**
 * 环境
 */
public class Context {

    private HashMap<AbstractExpression, Object> map = new HashMap<>();

    public void put(AbstractExpression expression, Object o) {
        map.put(expression, o);
    }

    public Object get(AbstractExpression expression) {
        return map.get(expression);
    }
}
