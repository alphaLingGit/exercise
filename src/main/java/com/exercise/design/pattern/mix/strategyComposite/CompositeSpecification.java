package com.exercise.design.pattern.mix.strategyComposite;

public abstract class CompositeSpecification implements IUserSpecification{

    @Override
    public IUserSpecification and(IUserSpecification specification) {
        return new AndSpecification(this, specification);
    }

    @Override
    public IUserSpecification or(IUserSpecification specification) {
        return new OrSpecification(this, specification);
    }

    @Override
    public IUserSpecification not() {
        return new NotSpecification(this);
    }
}
