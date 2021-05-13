package com.exercise.design.pattern.create.signleton;

/**
 * 静态内部类的形式去创建单例的，用到才创建，且不会引起线程安全问题，缺点为：外部无法传递参数进去
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    private static class SingleTonHoler {
        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingleTonHoler.INSTANCE;
    }

}
