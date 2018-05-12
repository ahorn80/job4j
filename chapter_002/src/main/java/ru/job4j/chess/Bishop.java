package ru.job4j.chess;

/**
 * class for chess figure bishop
 */
public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {

        int diffRow = dest.getRow() - source.getRow();
        int diffCol = dest.getCol() - source.getCol();
        if (!source.isValid() || !dest.isValid()
                || (Math.abs(diffRow) != Math.abs(diffCol))) {
            throw new ImpossibleMoveException();
        }
        int countCells = Math.abs(diffRow) + 1;
        Cell[] cells = new Cell[countCells];
        int stepRow = diffRow >= 0 ? 1 : -1;
        int stepCol = diffCol >= 0 ? 1 : -1;
        for (int i = 0; i < countCells; i++) {
            cells[i] = new Cell(source.getRow() + i * stepRow, source.getCol() + i * stepCol);
        }
        return cells;
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
