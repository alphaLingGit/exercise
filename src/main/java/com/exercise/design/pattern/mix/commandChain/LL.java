package com.exercise.design.pattern.mix.commandChain;

public class LL extends AbstractLL {
    @Override
    protected String getOperateParam() {
        return DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls_l(vo.getCommandName());
    }
}
