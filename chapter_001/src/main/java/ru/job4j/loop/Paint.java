package ru.job4j.loop;

public class Paint {
    /**
     * creates a string of pyramid as pseudo graphic
     * @param h pyramid height
     * @return string of pyramid
     */
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
        final int width = h * 2 - 1;
        for (int rowIndex = 0; rowIndex < h; rowIndex++) {
            for (int colIndex = 0; colIndex < width; colIndex++) {
                if (colIndex < -rowIndex + h - 1 || colIndex > rowIndex + h - 1) {
                    screen.append(" ");
                } else {
                    screen.append("^");
                }
            }
            screen.append(System.lineSeparator());
        }
        return  screen.toString();
    }
}
