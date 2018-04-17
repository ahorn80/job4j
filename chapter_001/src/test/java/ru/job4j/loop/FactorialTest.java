package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenEnter5Then120() {
        Factorial myCalculation = new Factorial();
        int factorialValue = myCalculation.calc(5);
        assertThat(factorialValue, is(120));
    }

    @Test
    public void whenEnter0Then1() {
        Factorial myCalculation = new Factorial();
        int factorialValue = myCalculation.calc(0);
        assertThat(factorialValue, is(1));
    }
}