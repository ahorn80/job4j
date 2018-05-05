package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
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
