package com.exercise.design.pattern.mix.commandChain;

public class LS_L extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return L_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls_l(vo.getCommandName());
    }
}
