package com.exercise.design.pattern.mix.factoryStrategy;

/**
 * 策略工厂
 */
public class StrategyFactory {

    public static IDeduction getDeduction(StrategyMan strategyMan) {
        IDeduction deduction = null;
        try {
            deduction = (IDeduction) Class.forName(strategyMan.getValue()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deduction;
    }
}
