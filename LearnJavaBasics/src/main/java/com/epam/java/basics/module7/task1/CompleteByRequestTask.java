package com.epam.java.basics.module7.task1;

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