package com.exercise.test;

import org.junit.Test;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;

public class CreateObjectTest implements Cloneable, Serializable {

    @Test
    public void newObject() {
        CreateObjectTest objectTest = new CreateObjectTest();
        System.out.println(objectTest);
    }

    @Test
    public void cloneObject() {
        CreateObjectTest objectTest = new CreateObjectTest();
        System.out.println(objectTest);
        try {
            CreateObjectTest clone = (CreateObjectTest) objectTest.clone();
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serialize() {
        try {
            CreateObjectTest objectTest = new CreateObjectTest();
            System.out.println(objectTest);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.ser"));
            objectOutputStream.writeObject(objectTest);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.ser"));
            CreateObjectTest readObject = (CreateObjectTest) objectInputStream.readObject();
            System.out.println(readObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflect() {
        try {
            CreateObjectTest instance = CreateObjectTest.class.newInstance();
            System.out.println(instance);
            // 调用构造方法
            CreateObjectTest newInstance = CreateObjectTest.class.getConstructor().newInstance();
            System.out.println(newInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unSafe() {
        try {
            // 仅通过Class对象就可以创建此类的实例对象，而且不需要调用其构造函数、初始化代码、JVM安全检查等。
            // 它抑制修饰符检测，也就是即使构造器是private修饰的也能通过此方法实例化，只需提类对象即可创建相应的对象
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe)field.get(null);
            CreateObjectTest instance = (CreateObjectTest) unsafe.allocateInstance(CreateObjectTest.class);
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
