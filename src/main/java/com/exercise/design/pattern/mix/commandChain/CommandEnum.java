package com.exercise.design.pattern.mix.commandChain;

import java.util.ArrayList;
import java.util.List;

public enum CommandEnum {

    ls("com.exercise.design.pattern.mix.commandChain.LSCommand"),
    ll("com.exercise.design.pattern.mix.commandChain.LLCommand");

    private String value = "";

    CommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getNames() {
        CommandEnum[] commandEnums = CommandEnum.values();
        List<String> names = new ArrayList<>();
        for (CommandEnum commandEnum : commandEnums) {
            names.add(commandEnum.name());
        }
        return names;
    }
}
