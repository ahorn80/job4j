package ru.job4j.loop;

public class Counter {

    /**
     * calculates sum of even numbers in given range
     * @param start from
     * @param finish to
     * @return sum of even numbers
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
