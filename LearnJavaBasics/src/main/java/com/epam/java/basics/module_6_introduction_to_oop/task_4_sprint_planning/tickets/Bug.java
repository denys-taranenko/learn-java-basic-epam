package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets;

public class Bug extends Ticket {
    private final UserStory userStory;

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || !userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }
}