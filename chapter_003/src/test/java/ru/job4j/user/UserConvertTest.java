package ru.job4j.user;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenEnterListOfUserThenMap() {
        List<User> list = Arrays.asList(
                new User(1, "name1", "city1"),
                new User(2, "name2", "city2"),
                new User(3, "name3", "city3")
        );
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, new User(1, "name1", "city1"));
        expected.put(2, new User(2, "name2", "city2"));
        expected.put(3, new User(3, "name3", "city3"));
        assertThat(new UserConvert().process(list), is(expected));
    }
}