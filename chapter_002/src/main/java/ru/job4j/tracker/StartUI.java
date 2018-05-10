package ru.job4j.tracker;

public class StartUI {
    /**
     * get data from user
     */
    private final Input input;
    /**
     * repository of requests
     */
    private final Tracker tracker;

    private final int[] range = {0, 1, 2, 3, 4, 5, 6};

    /**
     * constructor with initialization of member variables
     * @param input input data
     * @param tracker repository of requests
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * main loop
     */
    public void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while (!exit) {
            menu.show();
            int key = this.input.ask("Select : ", range);
            menu.select(key);
            if (key == 6) {
                exit = true;
            }
        }
    }

    /**
     * starts program
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
