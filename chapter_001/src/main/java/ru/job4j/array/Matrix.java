package ru.job4j.array;

public class Matrix {
    /**
     * creates multiply matrix of size x size
     * @param size matrix size
     * @return matrix size x xsize
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}