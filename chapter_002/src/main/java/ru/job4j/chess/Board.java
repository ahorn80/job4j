package ru.job4j.chess;

/**
 * chess board simulation
 */
public class Board {
    /**
     * array for figures
     */
    private Figure[] figures = new Figure[32];

    /**
     * method adds figure if possible
     * @param figure figure to add
     * @return true when figure added, false otherwise
     */
    public boolean add(Figure figure) {
        boolean ret = false;
        if (!this.isFree(figure.getPosition())) {
            return ret;
        }
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] == null) {
                this.figures[i] = figure;
                ret = true;
                break;
            }
        }
        return ret;
    }

    /**
     * method for moving figures from source to dest
     * @param source source
     * @param dest dest
     * @return true if movement successful
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean ret = false;
        Figure figure = this.getFigure(source);
        if (figure == null) {
            throw new FigureNotFoundException();
        }
        Cell[] cells = figure.way(source, dest);
        for (Cell cell : cells) {
            if (!source.equals(cell) && !this.isFree(cell)) {
                throw new OccupiedWayException();
            }
        }
        for (int i = 0; i < this.figures.length; i++) {
            if (figure == this.figures[i]) {
                this.figures[i] = figure.copy(dest);
                ret = true;
                break;
            }
        }
        return ret;
    }

    /**
     * method checks if given cell is free
     * @param cell cell to check
     * @return true if no figure is on this cell
     */
    private boolean isFree(Cell cell) {
        return (this.getFigure(cell) == null ? true : false);
    }

    /**
     * method gets figure in given cell
     * @param cell position of figure
     * @return figure in given cell or null if no figure exists
     */
    private Figure getFigure(Cell cell) {
        Figure ret  = null;
        for (Figure figure : this.figures) {
            if (figure != null && cell.equals(figure.getPosition())) {
                ret = figure;
                break;
            }
        }
        return ret;
    }
}
