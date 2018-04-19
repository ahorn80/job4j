package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * removes duplicate strings from string array
     * @param array input string array
     * @return string array without duplicates
     */
    public String[] remove(String[] array) {
        int backIndexToSwap = array.length - 1;
        int firstIndexToCheck = 0;
        while (firstIndexToCheck < backIndexToSwap) {
            for (int i = firstIndexToCheck + 1; i <= backIndexToSwap; i++) {
                if (array[firstIndexToCheck].equals(array[i])) {
                    String temp = array[i];
                    array[i] = array[backIndexToSwap];
                    array[backIndexToSwap] = temp;
                    backIndexToSwap--;
                    i--; //check swapped value in next iteration
                }
            }
            firstIndexToCheck++;
        }
        return Arrays.copyOf(array, backIndexToSwap + 1);
    }
}
