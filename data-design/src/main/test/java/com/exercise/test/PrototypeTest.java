package com.exercise.test;

import com.exercise.design.pattern.create.prototype.ConcretePrototype1;
import com.exercise.design.pattern.create.prototype.ConcretePrototype2;
import com.exercise.design.pattern.create.prototype.Prototype;
import org.junit.Test;

public class PrototypeTest {

    @Test
    public void prototype() {
        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
        System.out.println(concretePrototype1);
        Prototype clone1 = concretePrototype1.clone();
        System.out.println(clone1);
        ConcretePrototype2 concretePrototype2 = new ConcretePrototype2();
        System.out.println(concretePrototype2);
        Prototype clone2 = concretePrototype2.clone();
        System.out.println(clone2);

    }
}
