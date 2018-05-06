package ru.job4j.array;

public class ArrayMerge {
    /**
     * merges 2 sorted arrays to 1 sorted array
     * @param first first array
     * @param second sedond array
     * @return sorted array
     */
    public int[] mergeSortedArrays(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int iFirst = 0;
        int iSecond = 0;
        int iResult = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[iResult++] = first[iFirst++];
            } else {
                result[iResult++] = second[iSecond++];
            }
        }
        for (int i = iFirst; i < first.length; i++) {
            result[iResult++] = first[i];
        }
        for (int i = iSecond; i < second.length; i++) {
            result[iResult++] = second[i];
        }
        return result;
    }
}
