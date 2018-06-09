package ru.job4j.user;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenInputListThenSortedSet() {
        SortUser sorter = new SortUser();
        User user1 = new User(1, "user1", "city1");
        user1.setAge(10);
        User user2 = new User(2, "user2", "city2");
        user2.setAge(20);
        User user3 = new User(3, "user3", "city3");
        user3.setAge(30);
        List<User> unsorted = Arrays.asList(user2, user3, user1);
        List<User> sorted = Arrays.asList(user1, user2, user3);
        Set<User> result = sorter.sort(unsorted);
        assertThat(result.toArray(), is(sorted.toArray()));
    }
}