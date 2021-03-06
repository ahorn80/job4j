package ru.job4j.list;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenEmptyListThenEmptyResult() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(),
                3
        );
        int[][] expect = {
                {},
                {},
                {}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenInputListOfArrayThenOneListOut() {
        ConvertList2Array convert = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6, 7});
        list.add(new int[]{8, 9});
        List<Integer> result = convert.convert(list);
        assertThat(result, is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
}