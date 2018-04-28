package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenAddItemsWithSameNameThenReturnThem() {
        Tracker tracker = new Tracker();
        Item first = new Item("t1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("t2", "testDescription2", 1235L);
        tracker.add(second);
        Item third = new Item("t1", "testDescription3", 1236L);
        tracker.add(third);
        Item[] t1Items = tracker.findByName("t1");
        assertThat(t1Items.length, is(2));
    }

    @Test
    public void whenDeleteItemByIdThenItemsCountDecreases() {
        Tracker tracker = new Tracker();
        Item first = new Item("t1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("t2", "testDescription2", 1235L);
        tracker.add(second);
        Item third = new Item("t1", "testDescription3", 1236L);
        tracker.add(third);
        tracker.delete(first.getId());
        Item[] t1Items = tracker.findByName("t1");
        assertThat(t1Items.length, is(1));
    }

    @Test
    public void whenDeleteAllItemsThenEmptyList() {
        Tracker tracker = new Tracker();
        Item first = new Item("t1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("t2", "testDescription2", 1235L);
        tracker.add(second);
        Item third = new Item("t1", "testDescription3", 1236L);
        tracker.add(third);
        tracker.delete(first.getId());
        tracker.delete(second.getId());
        tracker.delete(third.getId());
        Item[] t1Items = tracker.findAll();
        assertThat(t1Items.length, is(0));
    }

    @Test
    public void whenFindInvalidIdThenReturnNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("t1", "testDescription1", 123L);
        tracker.add(first);
        Item invalidItem = tracker.findById("invalid");
        assertThat(invalidItem, is((Item) null));
    }
}
