package com.exercise.design.pattern.mix.factoryStrategy;

public class Card {

    private String cardNo;
    private double steadyMoney;
    private double freeMoney;

    public Card(String cardNo, double steadyMoney, double freeMoney) {
        this.cardNo = cardNo;
        this.steadyMoney = steadyMoney;
        this.freeMoney = freeMoney;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getSteadyMoney() {
        return steadyMoney;
    }

    public void setSteadyMoney(double steadyMoney) {
        this.steadyMoney = steadyMoney;
    }

    public double getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(double freeMoney) {
        this.freeMoney = freeMoney;
    }

    public void showCard() {
        System.out.println("IC卡号：" + cardNo);
        System.out.println("固定金额：" + steadyMoney);
        System.out.println("自由金额：" + freeMoney);
    }
}
