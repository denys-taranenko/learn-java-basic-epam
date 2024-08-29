package com.epam.java.basics.module6.task4.tickets;

public class Ticket {
    private final int id;
    private final String name;
    private final int estimate;
    private boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }

    public int getEstimate() {
        return estimate;
    }
}