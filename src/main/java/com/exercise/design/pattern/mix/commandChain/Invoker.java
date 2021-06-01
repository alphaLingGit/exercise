package com.exercise.design.pattern.mix.commandChain;

public class Invoker {

    public String exec(String commandStr) {
        String result = "";
        CommandVo commandVo = new CommandVo(commandStr);
        if (CommandEnum.getNames().contains(commandVo.getCommandName())) {
           String className = CommandEnum.valueOf(commandVo.getCommandName()).getValue();
           Command command;
            try {
                command = (Command)Class.forName(className).newInstance();
                result = command.execute(commandVo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            result = "无法执行命令，情检查命令格式！";
        }
        return result;
    }
}
