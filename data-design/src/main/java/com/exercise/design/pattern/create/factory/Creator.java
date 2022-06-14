package com.exercise.design.pattern.create.factory;

public interface Creator {

    <T extends Product> T factory(Class<T> tClass);

}
