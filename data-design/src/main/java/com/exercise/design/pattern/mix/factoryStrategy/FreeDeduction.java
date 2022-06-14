package com.exercise.design.pattern.mix.factoryStrategy;

/**
 * 自由消费扣款策略
 */
public class FreeDeduction implements IDeduction {
    @Override
    public synchronized boolean exec(Card card, Trade trade) {
        double amount = trade.getAmount();
        double steadyMoney = card.getSteadyMoney();
        double freeMoney = card.getFreeMoney();
        if (amount > steadyMoney) {
            return false;
        }
        card.setFreeMoney(freeMoney - amount);
        return true;
    }
}
