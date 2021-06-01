package com.exercise.design.pattern.mix.commandChain;

public class LS extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls(vo.getCommandName());
    }
}
