package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;
    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException ex) {
                System.out.println("Select valid key from menu");

            } catch (NumberFormatException ex) {
                System.out.println("Enter valid key");
            }

        } while (invalid);
        return value;
    }
}
