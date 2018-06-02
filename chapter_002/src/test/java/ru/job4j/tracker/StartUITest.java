package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    final java.lang.String lineSeparator = System.getProperty("line.separator");
    /**
     * default output to console
     */
    private final PrintStream stdout = System.out;
    /**
     * buffer for output
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "new desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasNoItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenUserDeleteWithInvalidIdThenTrackerHasNoChange() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "3", "invalidId", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(1));
    }

    @Test
    public void whenUserAddsTwoItemsThenTrackerHasTwo() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "0", "name2", "desc2", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(2));
    }

    @Test
    public void whenShowAllItemsThenShowThem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(this.getMenuText())
                                .append("------------ show all requests --------------").append(lineSeparator)
                                .append("ID: ").append(item.getId())
                                .append(" name: ").append(item.getName())
                                .append(" description: ").append(item.getDesc()).append(lineSeparator)
                                .append(this.getMenuText())
                                .toString()
                )
        );
    }

    @Test
    public void whenShowItemByIDThenShowIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(this.getMenuText())
                                .append("------------ find request by id--------------").append(lineSeparator)
                                .append("ID: ").append(item.getId())
                                .append(" name: ").append(item.getName())
                                .append(" description: ").append(item.getDesc()).append(lineSeparator)
                                .append(this.getMenuText())
                                .toString()
                )
        );
    }

    @Test
    public void whenShowItemByNameThenShowIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", "name", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(this.getMenuText())
                                .append("------------ find requests by name--------------").append(lineSeparator)
                                .append("ID: ").append(item.getId())
                                .append(" name: ").append(item.getName())
                                .append(" description: ").append(item.getDesc()).append(lineSeparator)
                                .append(this.getMenuText())
                                .toString()
                )
        );
    }

    /**
     * get menu text from StartUI
     * @return
     */
    private String getMenuText() {
        return  new StringBuilder()
                .append("Menu:").append(lineSeparator)
                .append("0. Add new Item").append(lineSeparator)
                .append("1. Show all items").append(lineSeparator)
                .append("2. Edit item").append(lineSeparator)
                .append("3. Delete item").append(lineSeparator)
                .append("4. Find item by Id").append(lineSeparator)
                .append("5. Find items by name").append(lineSeparator)
                .append("6. Exit Program").append(lineSeparator)
                .toString();
    }
}
