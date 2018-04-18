package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound1Then1() {
        Square square = new Square();
        int[] rst = square.calculate(1);
        int[] expect = new int[] {1};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound0ThenEmptyArray() {
        Square square = new Square();
        int[] rst = square.calculate(0);
        int[] expect = new int[0];
        assertThat(rst, is(expect));
    }
}