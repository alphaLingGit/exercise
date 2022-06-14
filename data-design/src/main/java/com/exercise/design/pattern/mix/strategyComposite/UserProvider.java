package com.exercise.design.pattern.mix.strategyComposite;

import java.util.ArrayList;
import java.util.List;

public class UserProvider implements IUserProvider{

    private List<User> userList;

    public UserProvider(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public List<User> findUser(IUserSpecification specification) {
        List<User> result = new ArrayList<>();
        for (User user : userList) {
            if (specification.isSatisfiedBy(user)) {
                result.add(user);
            }
        }
        return result;
    }
}
