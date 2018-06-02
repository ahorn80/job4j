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
        int index = 0;
        for (Integer value : list) {
            array[index / cols][index % cols] = value;
            index++;
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