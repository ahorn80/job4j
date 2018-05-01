package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static  org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        final String lineSeparator = System.getProperty("line.separator");
        Square square = new Square();
        assertThat(
            square.draw(),
            is(
                    new StringBuilder()
                    .append("o o o o o").append(lineSeparator)
                    .append("o       o").append(lineSeparator)
                    .append("o       o").append(lineSeparator)
                    .append("o       o").append(lineSeparator)
                    .append("o o o o o").append(lineSeparator)
                    .toString()
            )
        );
    }
}