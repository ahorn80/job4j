package ru.job4j.pseudo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        final String lineSeparator = System.getProperty("line.separator");
        Triangle triangle = new Triangle();
        assertThat(
            triangle.draw(),
            is(
                    new StringBuilder()
                    .append("    o    ").append(lineSeparator)
                    .append("   o o   ").append(lineSeparator)
                    .append("  o   o  ").append(lineSeparator)
                    .append(" o     o ").append(lineSeparator)
                    .append("o o o o o").append(lineSeparator)
                    .toString()
            )
        );
    }
}
