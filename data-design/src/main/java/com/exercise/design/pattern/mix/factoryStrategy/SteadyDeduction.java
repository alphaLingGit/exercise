package com.exercise.design.pattern.mix.factoryStrategy;

/**
 * 固定消费扣款策略
 */
public class SteadyDeduction implements IDeduction {
    @Override
    public synchronized boolean exec(Card card, Trade trade) {
        double amount = trade.getAmount();
        double steadyMoney = card.getSteadyMoney();
        double freeMoney = card.getFreeMoney();
        if (amount > steadyMoney + freeMoney) {
            return false;
        }
        if (steadyMoney > freeMoney) {
            card.setSteadyMoney(steadyMoney - amount);
            return true;
        } else {
            card.setSteadyMoney(0.0);
            card.setFreeMoney(freeMoney + steadyMoney - amount);
            return true;
        }
    }
}
