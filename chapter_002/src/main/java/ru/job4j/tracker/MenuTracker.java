package ru.job4j.tracker;

/**
 * adds item
 */
class AddItem implements UserAction {
    public int key() {
        return 0;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ add new request --------------");
        String name = input.ask("Enter request name :");
        String desc = input.ask("Enter request description :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("New request added:");
        System.out.println(item);
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Add new Item");
    }
}

/**
 * show all items
 */
class ShowItems implements UserAction {
    public int key() {
        return 1;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ show all requests --------------");
        Item[] items = tracker.findAll();
        for (Item item:items) {
            System.out.println(item);
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Show all items");
    }
}

/**
 * edits item
 */
class EditItem implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ edit request --------------");
        String id = input.ask("Enter request ID :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Request found:");
            System.out.println(item);
            String name = input.ask("Enter new request name :");
            String desc = input.ask("Enter new request description :");
            Item editedItem = new Item(name, desc);
            editedItem.setId(item.getId());
            tracker.replace(id, editedItem);
            System.out.println("Request changed:");
            System.out.println(editedItem);
        } else {
            System.out.println("Request with ID:" + id + " doesn't exists");
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}

/**
 * deletes item
 */
class DeleteItem implements UserAction {
    public int key() {
        return 3;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ delete request --------------");
        String id = input.ask("Enter request ID :");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            System.out.println("Request deleted");
        } else {
            System.out.println("Request with ID:" + id + " doesn't exists");
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }
}

/**
 * Find item by Id
 */
class FindItemById implements UserAction {
    public int key() {
        return 4;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ find request by id--------------");
        String id = input.ask("Enter request ID :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Request with ID:" + id + " doesn't exists");
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }
}


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        actions[0] = new AddItem();
        actions[1] = new ShowItems();
        actions[2] = new EditItem();
        actions[3] = new DeleteItem();
        actions[4] = new FindItemById();
        actions[5] = new FindItemByName();
        actions[6] = new MenuTracker.ExitProgram();
    }

    /**
     * select and execute action for given key
     * @param key action index
     */
    public void select(int key) {
        if (key >= 0 && key < this.actions.length) {
            this.actions[key].execute(this.input, this.tracker);
        }
    }

    /**
     * shows selection menu
     */
    public void show() {
        System.out.println("Menu:");
        for (UserAction action:actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Find item by name
     */
    class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ find requests by name--------------");
            String name = input.ask("Enter request name :");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                System.out.println("No request found with name: " + name);
            } else {
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    /**
     * exit program, no operation
     */
    private static class ExitProgram implements UserAction {
        public int key() {
            return 6;
        }

        /**
         * no operation
         * @param input input
         * @param tracker tracker
         */
        public void execute(Input input, Tracker tracker) {
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}
