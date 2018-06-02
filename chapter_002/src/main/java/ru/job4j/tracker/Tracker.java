package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private final Random numbers = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        long number = System.currentTimeMillis() + numbers.nextInt(100);
        return String.valueOf(number);
    }

    /**
     * replace item with given id
     * @param id item id
     * @param item item to replace
     */
    public void replace(String id, Item item) {
        int index = 0;
        for (Item current : this.items) {
            if (current != null && current.getId().equals(id)) {
               this.items.set(index, item);
               break;
            }
            index++;
        }
    }

    /**
     * deletes item with given id
     * @param id id of item to delete
     */
    public void delete(String id) {
        List<Item> toDelete = new ArrayList<>();
        for (Item current : this.items) {
            if (current != null && current.getId().equals(id)) {
                toDelete.add(current);
            }
        }
        this.items.removeAll(toDelete);
    }

    /**
     * get all items
     * @return all items
     */
    public List<Item> findAll() {
          return this.items;
    }

    /**
     * Get item array by given name
     * @param key name of item
     * @return item array
     */
    public List<Item> findByName(String key) {
        List<Item> ret = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                ret.add(item);
            }
        }
        return ret;
    }

    /**
     * get item by given id
     * @param id id of item
     * @return found item or null
     */
    public Item findById(String id) {
        Item ret = null;
        for (Item current : this.items) {
            if (current != null && current.getId().equals(id)) {
                ret = current;
                break;
            }
        }
        return ret;
    }
}