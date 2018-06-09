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

    @Test
    public void whenDifferentNameLengthThenSortByLength() {
        SortUser sorter = new SortUser();
        User user1 = new User(1, "user123", "city1");
        user1.setAge(10);
        User user2 = new User(2, "user1234", "city2");
        user2.setAge(20);
        User user3 = new User(3, "user12345", "city3");
        user3.setAge(30);
        List<User> unsorted = Arrays.asList(user2, user3, user1);
        List<User> sorted = Arrays.asList(user1, user2, user3);
        List<User>  result = sorter.sortNameLength(unsorted);
        assertThat(result, is(sorted));
    }

    @Test
    public void whenUnsortedListThenSortByNameAndAge() {
        SortUser sorter = new SortUser();
        User user1 = new User(1, "Alex", "city1");
        user1.setAge(10);
        User user2 = new User(2, "Bob", "city2");
        user2.setAge(20);
        User user3 = new User(3, "Denis", "city3");
        user3.setAge(30);
        User user4 = new User(4, "Denis", "city4");
        user4.setAge(40);
        List<User> unsorted = Arrays.asList(user2, user4, user3, user1);
        List<User> sorted = Arrays.asList(user1, user2, user3, user4);
        List<User>  result = sorter.sortByAllFields(unsorted);
        List<User>  result2 = sorter.sortNameLength(unsorted);
        assertThat(result, is(sorted));
    }
}