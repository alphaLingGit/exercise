package com.exercise.design.pattern.mix.commandChain;

public abstract class CommandName {

    private CommandName nextOperator;

    public final String handleMessage(CommandVo vo) {
        String result = "";
        if (vo.getParam().size() == 0 || vo.getParam().contains(getOperateParam())) {
            result = echo(vo);
        } else {
            if (nextOperator != null) {
                result = nextOperator.handleMessage(vo);
            } else {
               result = "命令无法执行";
            }
        }
        return result;
    }

    public void setNext(CommandName operator) {
        nextOperator = operator;
    }

    protected abstract String getOperateParam();

    protected abstract String echo(CommandVo vo);
}
