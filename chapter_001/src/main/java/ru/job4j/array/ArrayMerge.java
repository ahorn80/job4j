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
        if (iFirst < first.length) {
            System.arraycopy(first, iFirst, result, iResult, first.length - iFirst);
        } else if (iSecond < second.length) {
            System.arraycopy(second, iSecond, result, iResult, second.length - iSecond);
        }
        return result;
    }
}
