package com.exercise.design.pattern.mix.commandChain;

public class LLCommand extends Command{
    @Override
    public String execute(CommandVo vo) {
        return buildChain(AbstractLL.class).get(0).handleMessage(vo);
    }
}
