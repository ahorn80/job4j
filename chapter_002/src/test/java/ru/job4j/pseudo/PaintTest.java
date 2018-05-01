package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    final java.lang.String lineSeparator = System.getProperty("line.separator");
    /**
     * default output to console
     */
    private final PrintStream stdout = System.out;
    /**
     * buffer for output
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenDrawSquare() {
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
    }

    @Test
    public void whenDrawTriangle() {
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
    }
}
