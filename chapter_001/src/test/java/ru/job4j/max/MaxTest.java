package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstGreaterSecondThenFirst() {
        Max myMax = new Max();
        int maxValue = myMax.max(2, 1);
        assertThat(maxValue, is(2));
    }

    @Test
    public void whenOneTwoThreeEnteredThenThree() {
        Max myMax = new Max();
        int maxValue = myMax.max(1, 2, 3);
        assertThat(maxValue, is(3));
    }
}
