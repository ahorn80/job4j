package ru.job4j.array;


public class Square {
    /**
     * calculates array of square numbers from 1 to bound
     * @param bound upper bound
     * @return array of square numbers
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}