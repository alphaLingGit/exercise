package com.exercise.test;

import com.exercise.design.pattern.create.signleton.*;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println(DoubleCheckLockSingleton.getInstance());
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);
        Thread thread8 = new Thread(runnable);
        Thread thread9 = new Thread(runnable);
        Thread thread0 = new Thread(runnable);
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

    @Test
    public void test() {
        File file = new File("D:/test.txt");
        int times = 0;
        while(!file.exists() && times < 600){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(times);
                times++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
