package ru.job4j.array;

public class Turn {
    /**
     * creates number array in reverse order
     * @param array input array
     * @return array in reverse order
     */
    public int[] turn(int[] array) {
        int halfArraySize = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            //at half size we already swapped whole array for even array size
            //for odd array size center element stays unchanged
            if (i == halfArraySize) {
                break;
            }
            int tempValue = array[i];
            int backIndex = array.length - 1 - i;
            array[i] = array[backIndex];
            array[backIndex] = tempValue;
        }
        return array;
    }
}
