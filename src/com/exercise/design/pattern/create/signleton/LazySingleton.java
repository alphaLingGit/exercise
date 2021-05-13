package com.exercise.design.pattern.create.signleton;

/**
 * 懒汉模式在方法被调用后才创建对象，以时间换空间，在多线程环境下存在风险。
 */
public class LazySingleton {

    private static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

}
