package ru.job4j.user;

import java.util.*;

public class SortUser {

    /**
     * method returns sorted set of given user list
     * @param list list of users
     * @return sorted set
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * method returns list of Users sorted by user name length
     * @param list list of users
     * @return
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return list;
    }

    /**
     * method returns list of Users sorted by user name and then user age
     * @param list list of users
     * @return
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int ret = o1.getName().compareTo(o2.getName());
                        if (ret == 0) {
                            ret = Integer.compare(o1.getAge(), o2.getAge());
                        }
                        return ret;
                    }
                }
        );
        return list;
    }
}

