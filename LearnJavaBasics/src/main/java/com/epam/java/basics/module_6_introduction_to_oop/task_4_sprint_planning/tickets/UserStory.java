package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    private final UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
        for (UserStory userStory : dependsOn) {
            if (!userStory.isCompleted()) {
                return;
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        return  Arrays.copyOfRange(dependsOn, 0, dependsOn.length);
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}