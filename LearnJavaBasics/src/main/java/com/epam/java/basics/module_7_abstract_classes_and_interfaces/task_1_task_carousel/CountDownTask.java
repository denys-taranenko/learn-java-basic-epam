package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_1_task_carousel;

public class CountDownTask implements Task {
    private int value;
    private boolean isCompleted;

    public CountDownTask(int value) {
        this.value = Math.max(value, 0);
        this.isCompleted = this.value == 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (getValue() > 0) {
            value--;
            isCompleted = getValue() == 0;
        }
    }

    @Override
    public boolean isFinished() {
        return isCompleted;
    }
}