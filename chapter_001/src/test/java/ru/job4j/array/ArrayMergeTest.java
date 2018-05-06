package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayMergeTest {
    @Test
    public void whenEnterSortedOddEvenArraysThenReturnMergedArray() {
        int[] odd = {1, 3, 5, 7, 9};
        int[] even = {2, 4, 6, 8};
        ArrayMerge merge = new ArrayMerge();
        assertThat(merge.mergeSortedArrays(odd, even), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void whenEnterSortedEvenOddArraysThenReturnMergedArray() {
        int[] odd = {1, 3, 5, 7, 9};
        int[] even = {2, 4, 6, 8};
        ArrayMerge merge = new ArrayMerge();
        assertThat(merge.mergeSortedArrays(even, odd), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void whenEnterEmptyArraysThenReturnEmptyArray() {
        int[] first = new int[0];
        ArrayMerge merge = new ArrayMerge();
        assertThat(merge.mergeSortedArrays(first, first), is(new int[0]));
    }
}
