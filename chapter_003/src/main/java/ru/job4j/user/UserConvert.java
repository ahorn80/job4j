package ru.job4j.user;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    /**
     * converts a list of User to Hashmap, using id from user as map key
     * @param list list of User
     * @return HashMap of User
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
