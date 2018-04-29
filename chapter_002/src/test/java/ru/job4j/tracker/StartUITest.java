package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
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
    public void whenUpdateInvalidIDThenTrackerHasNoChange() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "2", item.getId() + 1, "new name", "new desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("name"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasNoItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenUserDeleteWithInvalidIdThenTrackerHasNoChange() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "3", "invalidId", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
    }

    @Test
    public void whenUserAddsTwoItemsThenTrackerHasTwo() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "0", "name2", "desc2", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }
}
