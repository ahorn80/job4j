package ru.job4j.chess;

/**
 * abstract class for chess figures
 */
public abstract class Figure {
    /**
     * coordinates of figure
     */
    final Cell position;

    /**
     * ctor for figure
     * @param position initial position
     */
    public Figure(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return this.position;
    }

    /**
     * Calculates all Cells on the way from source to dest, inclusive source and destination
     * throws ImpossibleMoveException if this way is not possible
     * @param source from
     * @param dest to
     * @return array of cell positions
     * @throws ImpossibleMoveException
     */
    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * method for figure copy with new cell position
     * @param dest new position
     * @return figure with new position
     */
    abstract Figure copy(Cell dest);
}
