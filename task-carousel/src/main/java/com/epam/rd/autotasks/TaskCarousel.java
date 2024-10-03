package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private final int capacity;
    private final List<Task> tasks;
    private int currentIndex = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new ArrayList<>(capacity);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isFull() {
        return tasks.size() == capacity;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }


        Task currentTask = tasks.get(currentIndex);
        currentTask.execute();


        if (currentTask.isFinished()) {
            tasks.remove(currentIndex);
            if (tasks.size() > 0) {
                currentIndex %= tasks.size();
            } else {
                currentIndex = 0;
            }
        } else {
            currentIndex = (currentIndex + 1) % tasks.size();
        }

        return true;
    }
}