package com.exercise.design.pattern.mix.strategyComposite;

public class UserByAgeThan extends CompositeSpecification{

    private int age;

    public UserByAgeThan(int age) {
        this.age = age;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge() > age;
    }
}
