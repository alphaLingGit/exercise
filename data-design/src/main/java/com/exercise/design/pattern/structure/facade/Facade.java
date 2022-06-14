package com.exercise.design.pattern.structure.facade;

/**
 * 外观角色
 */
public class Facade {

    Subsystem subsystem = new Subsystem();

    public void method() {
        subsystem.method();
    }
}
