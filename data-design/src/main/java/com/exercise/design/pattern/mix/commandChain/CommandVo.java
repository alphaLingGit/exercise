package com.exercise.design.pattern.mix.commandChain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CommandVo {

    public final static String DIVIDE_FLAG = " ";

    public final static String PREFIX = "-";

    private String commandName;

    private List<String> paramList = new ArrayList<>();

    private List<String> dataList = new ArrayList<>();

    public CommandVo(String commandStr) {
        if (commandStr != null && commandStr.length() != 0) {
            String[] split = commandStr.split(CommandVo.DIVIDE_FLAG);
            commandName = split[0];
            for (int i = 1; i < split.length; i++) {
                String str = split[i];
                if (str.indexOf(CommandVo.PREFIX) == 0) {
                    paramList.add(str.replace(CommandVo.PREFIX, "").trim());
                } else {
                    dataList.add(str.trim());
                }
            }
        } else {
            System.out.println("命令解析失败, 必须传递一个命令才能执行！");
        }
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParam() {
        if (paramList.size() == 0) {
            paramList.add("");
        }
        return new ArrayList<>(new HashSet<>(paramList));
    }

    public List<String> getData() {
        return dataList;
    }
}
