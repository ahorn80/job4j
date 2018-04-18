package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenEnterEvenArrayThenSortArray() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {11, 20, 3, -3, 10, 0};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {-3, 0, 3, 10, 11, 20};
        assertThat(result, is(expect));
    }

    @Test
    public void whenEnterOddArrayThenSortArray() {
        BubbleSort sorter = new BubbleSort();
        int[] input = new int[] {2, 1, 5, 4, 3};
        int[] result = sorter.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }
}