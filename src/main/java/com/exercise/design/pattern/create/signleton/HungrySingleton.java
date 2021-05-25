package com.exercise.design.pattern.create.signleton;

/**
 * 饿汉模式在类被初始化时就已经在内存中创建了对象，以空间换时间，不存在线程安全问题
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private String str;

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

}
