package com.exercise.test;

import com.exercise.design.pattern.create.signleton.*;

public class SingletonTest {

    public static void main(String[] args) {

        System.out.println(DoubleCheckLockSingleton.getInstance());
        System.out.println(DoubleCheckLockSingleton.getInstance());
        System.out.println(DoubleCheckLockSingleton.getInstance());

        System.out.println(EnumSingleton.INSTANCE);
        System.out.println(EnumSingleton.INSTANCE);
        System.out.println(EnumSingleton.INSTANCE);

        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());

        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());

        System.out.println(StaticInnerClassSingleton.getInstance());
        System.out.println(StaticInnerClassSingleton.getInstance());
        System.out.println(StaticInnerClassSingleton.getInstance());

    }

}
