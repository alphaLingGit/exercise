package com.exercise.design.pattern.mix.strategyComposite;

public interface IUserSpecification {

    boolean isSatisfiedBy(User user);

    IUserSpecification and(IUserSpecification specification);

    IUserSpecification or(IUserSpecification specification);

    IUserSpecification not();

}
