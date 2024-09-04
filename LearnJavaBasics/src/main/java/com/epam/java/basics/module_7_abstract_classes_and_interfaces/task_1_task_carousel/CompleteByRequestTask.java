package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_1_task_carousel;

public class CompleteByRequestTask implements Task {
    private boolean isCompleted;
    private boolean isCompletedTask;

    @Override
    public void execute() {
        if (isCompletedTask) {
            isCompleted = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isCompleted;
    }

    public void complete() {
        isCompletedTask = true;
    }
}