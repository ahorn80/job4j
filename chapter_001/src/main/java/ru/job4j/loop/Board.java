package ru.job4j.loop;

public class Board {
    /**
     * creates string for chess simulation.
     * @param width column count
     * @param height row count
     * @return String with whitespaces and "X" as chess board
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                // условие проверки, что писать пробел или X
                if ((rowIndex + columnIndex) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}