package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    /**
     * converts integer list to 2d array with given count of rows,
     * fills missing elements with zeros
     *
     * @param list input list
     * @param rows row count
     * @return 2d array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cols = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int index = row * cols + col;
                array[row][col] = index < list.size() ? list.get(index) : 0;
            }
        }
        return array;
    }

    /**
     * converts list of int-arrays to one Integer list
     * @param list input list
     * @return output list of Interger
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> retList = new ArrayList<>();
        for (int[] current : list) {
            for (int element : current) {
                retList.add(element);
            }
        }
        return retList;
    }
}