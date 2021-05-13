package com.exercise.design.pattern.create.signleton;

/**
 * 双重锁懒汉模式,由于jvm存在乱序执行功能，DCL也会出现线程不安全的情况,
 * 这时使用volatile(
 * 1、保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
 * 2、禁止进行指令重排序。)可解决该问题
 * <p>
 * INSTANCE  = new SingleTon();
 * 这个步骤，其实在jvm里面的执行分为三步：
 * 1.在堆内存开辟内存空间。
 * 2.在堆内存中实例化SingleTon里面的各个参数。
 * 3.把对象指向堆内存空间。
 * jvm乱序执行，若在2没执行时先执行了3，则会使其他线程的INSTANCE不为空，直接返回，从而引发异常
 */
public class DoubleCheckLockSingleton {

    private volatile static DoubleCheckLockSingleton INSTANCE;

    private DoubleCheckLockSingleton() {
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLockSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
