package ru.job4j.user;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    /**
     * method returns sorted set of given user list
     * @param list list of users
     * @return sorted set
     */
    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>();
        users.addAll(list);
        return users;
    }
}
