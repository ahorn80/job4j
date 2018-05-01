package ru.job4j.pseudo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    final java.lang.String lineSeparator = System.getProperty("line.separator");

    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(out.toString(), is(
                new StringBuilder()
                .append("o o o o o").append(lineSeparator)
                .append("o       o").append(lineSeparator)
                .append("o       o").append(lineSeparator)
                .append("o       o").append(lineSeparator)
                .append("o o o o o").append(lineSeparator).append(lineSeparator)
                .toString()
        ));
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(out.toString(), is(
                new StringBuilder()
                        .append("    o    ").append(lineSeparator)
                        .append("   o o   ").append(lineSeparator)
                        .append("  o   o  ").append(lineSeparator)
                        .append(" o     o ").append(lineSeparator)
                        .append("o o o o o").append(lineSeparator).append(lineSeparator)
                        .toString()
        ));
        System.setOut(stdout);
    }
}
