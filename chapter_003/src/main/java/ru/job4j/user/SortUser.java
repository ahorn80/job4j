package ru.job4j.user;

import java.util.*;

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

    /**
     * method returns list of Users sorted by user name length
     * @param list list of users
     * @return
     */
    public List<User> sortNameLength(List<User> list) {
        List<User> sorted = new ArrayList<>();
        sorted.addAll(list);
        sorted.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int ret = 0;
                        if (o1.getName().length() < o2.getName().length()) {
                            ret = -1;
                        } else if (o1.getName().length() > o2.getName().length()) {
                            ret = 1;
                        }
                        return ret;
                    }
                }
        );
        return sorted;
    }

    /**
     * method returns list of Users sorted by user name and then user age
     * @param list list of users
     * @return
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> sorted = new ArrayList<>();
        sorted.addAll(list);
        sorted.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int ret = o1.getName().compareTo(o2.getName());
                        if (ret == 0) {
                            if (o1.getAge() < o2.getAge()) {
                                ret = -1;
                            } else if (o1.getAge() > o2.getAge()) {
                                ret = 1;
                            }
                        }
                        return ret;
                    }
                }
        );
        return sorted;
    }
}

