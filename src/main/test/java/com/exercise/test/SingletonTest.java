package com.exercise.test;

import com.exercise.design.pattern.create.signleton.*;
import org.junit.Test;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        TestThread thread1 = new TestThread();
        TestThread thread2 = new TestThread();
        TestThread thread3 = new TestThread();
        TestThread thread4 = new TestThread();
        TestThread thread5 = new TestThread();
        TestThread thread6 = new TestThread();
        TestThread thread7 = new TestThread();
        TestThread thread8 = new TestThread();
        TestThread thread9 = new TestThread();
        TestThread thread0 = new TestThread();
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        thread5.start();
        thread6.start();
        Thread.sleep(1000);
        thread7.start();
        thread8.start();
        thread9.start();
        thread0.start();
    }

    static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println(DoubleCheckLockSingleton.getInstance());
        }
    }

    @Test
    public void test() {

    }
}
