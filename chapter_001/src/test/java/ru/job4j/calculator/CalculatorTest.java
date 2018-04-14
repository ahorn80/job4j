package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculator test
 */
public class CalculatorTest {

    /**
     * test add
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        assertThat(result, is(2D));

    }

    /**
     * test sub
     */
    @Test
    public void whenSubtractTwoFromTenThenEight() {
        Calculator calc = new Calculator();
        calc.sub(10D, 2D);
        double result = calc.getResult();
        assertThat(result, is(8D));
    }

    /**
     * test mult
     */
    @Test
    public void whenMultTwoWithThreeThenSix() {
        Calculator calc = new Calculator();
        calc.mult(2D, 3D);
        double result = calc.getResult();
        assertThat(result, is(6D));
    }

    /**
     * test div
     */
    @Test
    public void whenDivSixByTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        assertThat(result, is(3D));
    }
}
