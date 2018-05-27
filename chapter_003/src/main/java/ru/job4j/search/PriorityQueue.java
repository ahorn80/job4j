package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int position = this.tasks.size();
        for (Task current : this.tasks) {
            if (task.getPriority() < current.getPriority()) {
                position = this.tasks.indexOf(current);
                break;
            }
        }
        this.tasks.add(position, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}