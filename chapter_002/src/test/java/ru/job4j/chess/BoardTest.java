package ru.job4j.chess;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoardTest {
    @Test
    public void whenAddFigureToEmptyBoardThenOK() {
        Board board = new Board();
        boolean ret = board.add(new Bishop(new Cell(1, 1)));
        assertThat(ret, is(true));
    }

    @Test
    public void whenMoveBishopDiagonalThenOK() {
        Board board = new Board();
        board.add(new Bishop(new Cell(1, 1)));
        board.add(new Bishop(new Cell(4, 4)));
        boolean ret = board.move(new Cell(1, 1), new Cell(3, 3));
        assertThat(ret, is(true));
    }

    @Test(expected = OccupiedWayException.class)
    public void whenMoveBishopOverOccupiedPositionThenException() {
        Board board = new Board();
        board.add(new Bishop(new Cell(1, 1)));
        board.add(new Bishop(new Cell(2, 2)));
        boolean ret = board.move(new Cell(1, 1), new Cell(8, 8));
        assertThat(ret, is(false));
    }

    @Test
    public void whenAddFigureToSamePositionThenError() {
        Board board = new Board();
        board.add(new Bishop(new Cell(1, 1)));
        boolean ret = board.add(new Bishop(new Cell(1, 1)));
        assertThat(ret, is(false));
    }

    @Test(expected = OccupiedWayException.class)
    public void whenMoveFigureToOccupiedCellThenException() {
        Board board = new Board();
        board.add(new Bishop(new Cell(1, 1)));
        board.add(new Bishop(new Cell(2, 2)));
        board.move(new Cell(1, 1), new Cell(2, 2));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveFigureToImpossiblePositionThenException() {
        Board board = new Board();
        board.add(new Bishop(new Cell(1, 1)));
        board.move(new Cell(1, 1), new Cell(8, 1));
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenTryMoveNotExistentFigureThenException() {
        Board board = new Board();
        board.add(new Bishop(new Cell(1, 1)));
        board.move(new Cell(2, 2), new Cell(3, 3));
    }
}
