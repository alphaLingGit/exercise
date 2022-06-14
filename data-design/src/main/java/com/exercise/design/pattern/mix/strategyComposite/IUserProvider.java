package com.exercise.design.pattern.mix.strategyComposite;

import java.util.List;

public interface IUserProvider {

    List<User> findUser(IUserSpecification specification);
}
