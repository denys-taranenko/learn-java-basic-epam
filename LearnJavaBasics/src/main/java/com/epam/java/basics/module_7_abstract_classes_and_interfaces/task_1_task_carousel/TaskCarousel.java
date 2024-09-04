package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_1_task_carousel;

public class TaskCarousel {
    private final int capacity;
    private final Task[] taskArray;
    private int taskCount;
    private int executePointer;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.taskArray = new Task[capacity];
        this.taskCount = 0;
        this.executePointer = -1;
    }

    private void removeTask(int index) {
        if (index < 0 || index >= taskCount) {
            return;
        }

        for (int i = index; i < taskCount - 1; i++) {
            taskArray[i] = taskArray[i + 1];
        }
        taskArray[taskCount - 1] = null;
        taskCount--;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }

        taskArray[taskCount] = task;
        taskCount++;
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        executePointer++;

        if (executePointer >= taskCount) {
            executePointer = 0;
        }

        Task currentTask = taskArray[executePointer];

        if (currentTask != null && !currentTask.isFinished()) {
            currentTask.execute();
            if (currentTask.isFinished()) {
                removeTask(executePointer);
                executePointer--;
            }
            return true;
        } else {
            return execute();
        }
    }

    public boolean isFull() {
        return capacity == taskCount;
    }

    public boolean isEmpty() {
        return taskCount == 0;
    }
}