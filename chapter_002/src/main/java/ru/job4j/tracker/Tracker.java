package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private final Random numberGenerator = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        long number = System.currentTimeMillis() + numberGenerator.nextInt(100);
        return String.valueOf(number);
    }

    /**
     * replace item with given id
     * @param id item id
     * @param item item to replace
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * deletes item with given id
     * @param id id of item to delete
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position - 1 - i);
                this.items[position - 1] = null;
                position--;
                break;
            }
        }
    }

    /**
     * get all items
     * @return all items
     */
    public Item[] findAll() {
        Item[] ret = new Item[this.position];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = this.items[i];
        }
        return ret;
    }

    /**
     * Get item array by given name
     * @param key name of item
     * @return item array
     */
    public Item[] findByName(String key) {
        Item[] ret = new Item[this.position];
        int foundItems = 0;
        for (int i = 0; i < ret.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                ret[foundItems++] = this.items[i];
            }
        }
        return Arrays.copyOf(ret, foundItems);
    }

    /**
     * get item by given id
     * @param id id of item
     * @return found item or null
     */
    public Item findById(String id) {
        Item ret = null;
        for (Item current: this.items) {
            if (current != null && current.getId().equals(id)) {
                ret = current;
                break;
            }
        }
        return ret;
    }
}