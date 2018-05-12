package ru.job4j.chess;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopTest {
    @Test
    public void whenMoveOneStepToLeftUpThenCheckPosition() {
        Bishop bishop = new Bishop(new Cell(1, 1));
        Cell[] expected = new Cell[]{new Cell(1, 1), new Cell(2, 2)};
        Cell[] result = bishop.way(new Cell(1, 1), new Cell(2, 2));
        assertThat(result, is(expected));
    }

    @Test
    public void whenMoveDiagonalFromLeftUptoBottomRightThenCheckPositions() {
        Bishop bishop = new Bishop(new Cell(1, 1));
        Cell[] expected = new Cell[]{
                new Cell(8, 1),
                new Cell(7, 2),
                new Cell(6, 3),
                new Cell(5, 4),
                new Cell(4, 5),
                new Cell(3, 6),
                new Cell(2, 7),
                new Cell(1, 8)
        };
        Cell[] result = bishop.way(new Cell(8, 1), new Cell(1, 8));
        assertThat(result, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveToInvalidPosThenException() {
        Bishop bishop = new Bishop(new Cell(1, 1));
        Cell[] result = bishop.way(new Cell(1, 1), new Cell(2, 1));
    }
}
