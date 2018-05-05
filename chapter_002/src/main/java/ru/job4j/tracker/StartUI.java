package ru.job4j.tracker;

public class StartUI {
    /**
     * Add new Item
     */
    private  static final String ADD = "0";
    /**
     * Show all items
     */
    private  static final String SHOW = "1";
    /**
     * Edit item
     */
    private  static final String EDIT = "2";
    /**
     * Delete item
     */
    private  static final String DELETE = "3";
    /**
     * Find item by Id
     */
    private  static final String FIND_BY_ID = "4";
    /**
     * Find items by name
     */
    private  static final String FIND_BY_NAME = "5";
    /**
     * Exit Program
     */
    private  static final String EXIT = "6";

    /**
     * get data from user
     */
    private final Input input;
    /**
     * repository of requests
     */
    private final Tracker tracker;

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
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * method adds new request to repository
     */
    private void createItem() {
        System.out.println("------------ add new request --------------");
        String name = this.input.ask("Enter request name :");
        String desc = this.input.ask("Enter request description :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("New request added:");
        this.printItem(item);
    }

    /**
     * print all requests
     */
    private void showAllItems() {
        System.out.println("------------ show all requests --------------");
        Item[] items = this.tracker.findAll();
        for (Item item:items) {
            this.printItem(item);
        }
    }

    /**
     * method edits requests description for entered id
     */
    private void editItem() {
        System.out.println("------------ edit request --------------");
        String id = this.getIDFromInput();
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Request found:");
            this.printItem(item);
            String name = this.input.ask("Enter new request name :");
            String desc = this.input.ask("Enter new request description :");
            Item editedItem = new Item(name, desc);
            editedItem.setId(item.getId());
            this.tracker.replace(id, editedItem);
            System.out.println("Request changed:");
            this.printItem(editedItem);
        } else {
            this.printInvalidItem(id);
        }
    }

    /**
     * deletes request with entered id
     */
    private void deleteItem() {
        System.out.println("------------ delete request --------------");
        String id = this.getIDFromInput();
        Item item = this.tracker.findById(id);
        if (item != null) {
            this.tracker.delete(id);
            System.out.println("Request deleted");
        } else {
            this.printInvalidItem(id);
        }
    }

    /**
     * method prints request with entered id
     */
    private  void findItemById() {
        System.out.println("------------ find request by id--------------");
        String id = this.getIDFromInput();
        Item item = this.tracker.findById(id);
        if (item != null) {
            this.printItem(item);
        } else {
            this.printInvalidItem(id);
        }
    }

    /**
     * method prints all requests with entered name
     */
    private  void findItemsByName() {
        System.out.println("------------ find requests by name--------------");
        String name = this.input.ask("Enter request name :");
        Item[] items = this.tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("No request found with name: " + name);
        } else {
            for (Item item : items) {
                this.printItem(item);
            }
        }
    }

    /**
     * method prints given request
     * @param item request
     */
    private void printItem(Item item) {
        if (item != null) {
            StringBuilder text = new StringBuilder();
            text.append("ID: ").append(item.getId());
            text.append(" name: ").append(item.getName());
            text.append(" description: ").append(item.getDesc());
            System.out.println(text.toString());
        }
    }

    /**
     * method asks user for ID of the request
     * @return ID
     */
    private String getIDFromInput() {
        return this.input.ask("Enter request ID :");
    }

    /**
     * method prints that request with given id doesn't exists
     * @param id ID of the request
     */
    private void printInvalidItem(String id) {
        System.out.println("Request with ID:" + id + " doesn't exists");
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * starts program
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
