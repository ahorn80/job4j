package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenFrom1To10Then30() {
        Counter myCounter = new Counter();
        int evenSum = myCounter.add(1, 10);
        assertThat(evenSum, is(30));
    }
}
