package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    /**
     * convertes 2d array row after row to list
     * @param array array
     * @return list of elements from 2d array
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        if (array.length > 0) {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[0].length; col++) {
                    list.add(array[row][col]);
                }
            }
        }
        return list;
    }
}