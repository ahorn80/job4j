package ru.job4j.array;

public class BubbleSort {
    /**
     * sort array
     * @param array input array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        boolean swapped = false;
        //upper array index for order check
        int upperIndexToCheck = array.length - 1;
        do {
            swapped = false;
            for (int i = 0; i < upperIndexToCheck; i++) {
                if (array[i] > array[i + 1]) {
                    int tempValue = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tempValue;
                    swapped = true;
                }
            }
            //we do not need to check already sorted elements at the end of array
            //in next iteration
            upperIndexToCheck--;
        } while (swapped);
        return array;
    }
}
