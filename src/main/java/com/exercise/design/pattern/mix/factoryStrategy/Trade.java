package com.exercise.design.pattern.mix.factoryStrategy;

/**
 * 交易
 */
public class Trade {

    private String tradeNo;
    private double amount;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
