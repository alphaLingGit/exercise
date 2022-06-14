package com.exercise.design.pattern.mix.factoryStrategy;

/**
 * 扣款模块封装
 */
public class DeductionFacade {

    private static StrategyMan getDeductionType(Trade trade) {
        if (trade.getTradeNo().startsWith("000")) {
            return StrategyMan.SteadyDeduction;
        } else {
            return StrategyMan.FreeDeduction;
        }
    }

    public static void deduct(Card card, Trade trade) {
        StrategyMan strategyMan = getDeductionType(trade);
        IDeduction deduction = StrategyFactory.getDeduction(strategyMan);
        if (deduction.exec(card, trade)) {
            System.out.println("=============交易凭证==========");
            System.out.println(trade.getTradeNo() + "交易成功");
            System.out.println("交易金额：￥" + trade.getAmount());
            System.out.println("===============================");
        } else {
            System.out.println("=============交易失败==========");
        }

    }
}
