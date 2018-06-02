package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}

/**
 * adds item
 */
class AddItem extends BaseAction {
    public AddItem(int key, String name) {
        super(key, name);
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
}

/**
 * show all items
 */
class ShowItems extends BaseAction {
    public ShowItems(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ show all requests --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }
}

/**
 * edits item
 */
class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
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
}

/**
 * deletes item
 */
class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
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
}

/**
 * Find item by Id
 */
class FindItemById extends BaseAction {
    public FindItemById(int key, String name) {
        super(key, name);
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
}


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        actions.add(new AddItem(0, "Add new Item"));
        actions.add(new ShowItems(1, "Show all items"));
        actions.add(new EditItem(2, "Edit item"));
        actions.add(new DeleteItem(3, "Delete item"));
        actions.add(new FindItemById(4, "Find item by Id"));
        actions.add(new FindItemByName(5, "Find items by name"));
        actions.add(new MenuTracker.ExitProgram(6, "Exit Program"));
    }

    /**
     * select and execute action for given key
     * @param key action index
     */
    public void select(int key) {
        if (key >= 0 && key < this.actions.size()) {
            this.actions.get(key).execute(this.input, this.tracker);
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
    class FindItemByName extends BaseAction {
        public FindItemByName(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ find requests by name--------------");
            String name = input.ask("Enter request name :");
            List<Item> items = tracker.findByName(name);
            if (items.size() == 0) {
                System.out.println("No request found with name: " + name);
            } else {
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        }
    }

    /**
     * exit program, no operation
     */
    private static class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }

        /**
         * no operation
         * @param input input
         * @param tracker tracker
         */
        public void execute(Input input, Tracker tracker) {
        }
    }
}
