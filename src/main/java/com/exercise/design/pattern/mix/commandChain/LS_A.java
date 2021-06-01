package com.exercise.design.pattern.mix.commandChain;

public class LS_A extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return A_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls_a(vo.getCommandName());
    }
}
