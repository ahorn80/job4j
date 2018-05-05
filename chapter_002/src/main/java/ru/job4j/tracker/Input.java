package ru.job4j.tracker;

public interface Input {
    /**
     * returns answer to question
     * @param question question
     * @return answer
     */
    String ask(String question);

    /**
     * returns answer to question
     * @param question question
     * @param range valid numbers
     * @return answer as integer
     */
    int ask(String question, int[] range);
}
