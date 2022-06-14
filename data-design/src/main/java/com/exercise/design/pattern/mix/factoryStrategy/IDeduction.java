package com.exercise.design.pattern.mix.factoryStrategy;

/**
 * 扣款策略
 */
public interface IDeduction {

    boolean exec(Card card, Trade trade);
}
