package com.exercise.design.pattern.create.abstractFactory;

public abstract class Factory {

    /**
     * 生产容器
     */
    public abstract Product ManufactureContainer();

    /**
     * 生产模组
     */
    public abstract Product ManufactureMould();

}
