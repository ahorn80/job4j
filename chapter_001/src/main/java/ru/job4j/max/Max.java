package ru.job4j.max;

/**
 * @author Andreas Horn (ahorn80@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * calculates max value
     * @param first first value
     * @param second second value
     * @return max value
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }
}

