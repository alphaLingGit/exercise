package com.exercise.design.pattern.mix.factoryStrategy;

public enum StrategyMan {

    SteadyDeduction("com.exercise.design.pattern.mix.factoryStrategy.SteadyDeduction"),
    FreeDeduction("com.exercise.design.pattern.mix.factoryStrategy.FreeDeduction");

    private String value;

    StrategyMan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
