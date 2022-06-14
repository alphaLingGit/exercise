package com.exercise.design.pattern.mix.commandChain;

public class FileManager {

    public static String ls(String name) {
        return "file1\nfile2\nfile3\nfile4";
    }

    public static String ls_l(String name) {
        String str = "drw-rw-rw root system 1024 2009-8-20 10:23 file1 \n";
        str += "drw-rw-rw root system 1024 2009-8-20 10:23 file2 \n";
        str += "drw-rw-rw root system 1024 2009-8-20 10:23 file3 \n";
        return str;
    }

    public static String ls_a(String name) {
        return ".\n..\nfile1\nfile2\nfile3";
    }
}
