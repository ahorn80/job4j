package ru.job4j.chess;

/**
 * class for chess positions
 */
public class Cell {
    /**
     * position in row, 1..8
     */
    private int row;
    /**
     * position in col, 1..8
     */
    private int col;
    /**
     * max row/col count
     */
    private final static int MAXROWCOL = 8;


    /**
     * ctor, takes row and column as position
     * @param row
     * @param col
     */
    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * returns row
     * @return row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * returns column
     * @return column
     */
    public int getCol() {
        return this.col;
    }

    /**
     * method returns true if positions of cells have same position
     * @param obj other cell
     * @return true if cells have same row and column
     */
    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj == null) {
            return ret;
        }
        if (this == obj) {
            return ret;
        }
        if (this.getClass() != obj.getClass()) {
            return ret;
        }
        Cell other = (Cell) obj;
        ret = (this.row == other.row && this.col == other.col);
        return ret;
    }

    /**
     * method checks if position of this cell is valid
     * @return true if position is valid
     */
    boolean isValid() {
        return (this.row >= 1 && this.row <= Cell.MAXROWCOL) && (this.col >= 1 && this.col <= Cell.MAXROWCOL);
    }

    @Override
    /**
     * for validate satisfaction
     */
    public int hashCode() {
        return super.hashCode();
    }
}
