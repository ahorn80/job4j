package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;
    private final int tableSize = 3; //set to fix size for this game

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return checkWinner(true);
    }

    public boolean isWinnerO() {
        return checkWinner(false);
    }

    public boolean hasGap() {
        boolean gapExists = false;
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (!table[i][j].hasMarkO() && !table[i][j].hasMarkX()) {
                    gapExists = true;
                    return gapExists;
                }
            }
        }
        return gapExists;
    }

    private boolean checkXorOIsSet(Figure3T figure, boolean checkX) {
        return checkX ? figure.hasMarkX() : figure.hasMarkO();
    }

    /**
     * checks if winner exists
     * @param checkX check winner for X or for O
     * @return winner exists
     */
    private boolean checkWinner(boolean checkX) {
        boolean hasWinner = false;
        int[] sumXorOInRow = {0, 0, 0}; //count in row 0,1,2
        int[] sumXorOInCol = {0, 0, 0}; //count in col 0,1,2
        int[] sumXorODiagonal = {0, 0}; //first value: diagonal from left upper to right bottom, second value: other diagonal
        //check in rows
        for (int row = 0; row < tableSize; row++) {
            for (int col = 0; col < tableSize; col++) {
                if (checkXorOIsSet(table[row][col], checkX)) {
                    sumXorOInRow[row]++;
                    sumXorOInCol[col]++;
                    if (row == col) {
                        sumXorODiagonal[0]++;
                        sumXorODiagonal[1]++;
                    } else if (tableSize - 1 - row == col) {
                        sumXorODiagonal[1]++;
                    }
                }
            }
        }
        //check count of X or O in all combinations:
        int[][] combinationsCount = {sumXorOInRow, sumXorOInCol, sumXorODiagonal};
        for (int[] currentCountArray: combinationsCount) {
            for (int i = 0; i < currentCountArray.length; i++) {
                if (currentCountArray[i] == 3) {
                    hasWinner = true;
                    return hasWinner;
                }
            }
        }
        return hasWinner;
    }
}