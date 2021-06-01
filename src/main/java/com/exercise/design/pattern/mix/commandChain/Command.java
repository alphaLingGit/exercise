package com.exercise.design.pattern.mix.commandChain;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    public abstract String execute(CommandVo vo);

    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> aClass) {
        List<Class> classes = ClassUtils.getSonClass(aClass);
        List<CommandName> commandNameList = new ArrayList<>();
        for (Class aClass1 : classes) {
            CommandName commandName = null;
            try {
                commandName = (CommandName)Class.forName(aClass1.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (commandNameList.size() > 0) {
                commandNameList.get(commandNameList.size() -1).setNext(commandName);
            }
            commandNameList.add(commandName);
        }
        return commandNameList;
    }
}
