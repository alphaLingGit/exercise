package com.exercise.design.pattern.mix.strategyComposite;

public class UserByNameLike extends CompositeSpecification {

    private static String LIKE = "%";
    private String name;

    public UserByNameLike(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        String name = user.getName();
        String str = this.name.replace("%", "");
        if (name.startsWith(LIKE) && name.endsWith(LIKE)) {
            return name.contains(str);
        } else if (name.startsWith(LIKE)) {
            return name.endsWith(str);
        } else {
            return name.startsWith(str);
        }
    }
}
