package com.exercise.design.pattern.create.factory.simple;

/**
 * 简单工厂根据传入的参数不同返回不同的实例，被创建的实例具有共同的父类或接口
 */
public class ShapeSimpleFactory {

    public static final String TAG = "ShapeFactory";

    public static Shape getShape(String type) {
        Shape shape = null;
        if (type.equalsIgnoreCase("circle")) {
            shape = new CircleShape();
        } else if (type.equalsIgnoreCase("rect")) {
            shape = new RectShape();
        } else if (type.equalsIgnoreCase("triangle")) {
            shape = new TriangleShape();
        }
        return shape;
    }

}
