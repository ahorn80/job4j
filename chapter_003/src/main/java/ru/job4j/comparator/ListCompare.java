package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int ret = 0;
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            ret = Character.compare(left.charAt(i), right.charAt(i));
            if (ret != 0) {
                return ret;
            }
        }
        ret = left.length() - right.length();
        return ret;
    }
}