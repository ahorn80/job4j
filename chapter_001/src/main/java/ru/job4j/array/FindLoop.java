package ru.job4j.array;

public class FindLoop {
    /**
     * searches in array data for value el
     * @param data input array
     * @param el searched value
     * @return index of value in array or -1 if not found
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}