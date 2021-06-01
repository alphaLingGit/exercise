package com.exercise.design.pattern.mix.commandChain;

public class LSCommand extends Command{
    @Override
    public String execute(CommandVo vo) {
        return buildChain(AbstractLS.class).get(0).handleMessage(vo);
    }
}
