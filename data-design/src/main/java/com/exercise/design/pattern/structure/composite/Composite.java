package com.exercise.design.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝构建
 */
public class Composite implements Component {

    private List<Component> componentList = new ArrayList<>();

    public void add(Component component) {
        componentList.add(component);
    }

    public void reomve(Component component) {
        componentList.remove(component);
    }

    public List<Component> getChild() {
        return componentList;
    }

    @Override
    public void operation() {

    }
}
