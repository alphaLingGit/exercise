package com.exercise.test;

import com.exercise.design.pattern.behavior.memento.Caretaker;
import com.exercise.design.pattern.behavior.memento.Originator;
import com.exercise.design.pattern.behavior.observer.ConcreteObserver;
import com.exercise.design.pattern.behavior.observer.ConcreteSubject;
import com.exercise.design.pattern.behavior.observer.Observer;
import com.exercise.design.pattern.behavior.state.Context;
import com.exercise.design.pattern.behavior.visitor.ConcreteVisitor;
import com.exercise.design.pattern.behavior.visitor.ObjectStructure;
import org.junit.Test;

public class BehaviorTest {

    @Test
    public void ObserverTest() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.attach(observer);
        subject.change();
    }

    @Test
    public void MementoTest() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.restoreMemento(caretaker.getMemento());
    }

    @Test
    public void visitorTest() {
        ObjectStructure structure = new ObjectStructure();
        structure.createElements();
        ConcreteVisitor visitor = new ConcreteVisitor();
        structure.action(visitor);
    }

    @Test
    public void stateTest() {
        Context context = new Context();
        context.handle1();
        context.handle2();
    }
}
