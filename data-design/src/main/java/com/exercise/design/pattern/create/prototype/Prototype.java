package com.exercise.design.pattern.create.prototype;

public interface Prototype extends Cloneable{

    /**
     * 一般调用父类clone方法（浅克隆），如有深克隆需求则要自己实现
     * @return 克隆对象
     */
    Prototype clone();

}
