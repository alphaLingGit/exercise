package com.exercise.design.pattern.mix.strategyComposite;

public class UserByNameEqual extends CompositeSpecification{

    private String name;

    public UserByNameEqual(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().equals(name);
    }
}
