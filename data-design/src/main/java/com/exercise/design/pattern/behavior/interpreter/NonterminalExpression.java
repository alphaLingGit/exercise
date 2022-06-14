package com.exercise.design.pattern.behavior.interpreter;

/**
 * 非终结符表达式
 */
public class NonterminalExpression extends AbstractExpression{


    /**
     * 每个非终结表达式都会对其他表达式产生依赖
     */
    public NonterminalExpression(AbstractExpression expression) {
    }

    @Override
    public Object interpreter(Context context) {
        return context.get(this);
    }
}
