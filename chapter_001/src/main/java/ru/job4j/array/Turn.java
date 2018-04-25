package ru.job4j.array;

public class Turn {
    /**
     * creates number array in reverse order
     * @param array input array
     * @return array in reverse order
     */
    public int[] turn(int[] array) {
        int halfArraySize = array.length / 2;
        for (int i = 0; i < halfArraySize; i++) {
            int tempValue = array[i];
            int backIndex = array.length - 1 - i;
            array[i] = array[backIndex];
            array[backIndex] = tempValue;
        }
        return array;
    }
}
