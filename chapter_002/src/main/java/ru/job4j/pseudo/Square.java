package ru.job4j.pseudo;

public class Square implements Shape {
    final String lineSeparator = System.getProperty("line.separator");
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("o o o o o").append(lineSeparator);
        pic.append("o       o").append(lineSeparator);
        pic.append("o       o").append(lineSeparator);
        pic.append("o       o").append(lineSeparator);
        pic.append("o o o o o").append(lineSeparator);
        return pic.toString();
    }

}
