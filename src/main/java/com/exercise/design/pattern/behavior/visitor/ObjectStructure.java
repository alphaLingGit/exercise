package com.exercise.design.pattern.behavior.visitor;

import java.util.Random;
import java.util.Vector;

public class ObjectStructure {

    private final Vector<Element> elements;

    public ObjectStructure() {
        elements = new Vector<>();
    }

    public void action(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

    public void add(Element element) {
        elements.add(element);
    }

    public void createElements() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            if (random.nextInt(100) > 50) {
                add(new ConcreteElement1());
            } else {
                add(new ConcreteElement2());
            }
        }
    }
}
