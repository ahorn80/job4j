package ru.job4j.array;

public class BubbleSort {
    /**
     * sort array
     * @param array input array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        for (int upperIndex = array.length - 1; upperIndex > 1; upperIndex--) {
            boolean swapped = false;
            for (int i = 0; i < upperIndex; i++) {
                if (array[i] > array[i + 1]) {
                    int tempValue = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tempValue;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
