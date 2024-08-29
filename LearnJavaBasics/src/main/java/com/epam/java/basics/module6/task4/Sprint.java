package com.epam.java.basics.module6.task4;

import com.epam.java.basics.module6.task4.tickets.Bug;
import com.epam.java.basics.module6.task4.tickets.Ticket;
import com.epam.java.basics.module6.task4.tickets.UserStory;

public class Sprint {
    private final int capacity;
    private final int ticketsLimit;
    private int totalEstimate;
    private int countTicket;
    private final Ticket[] currentTicket;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.totalEstimate = 0;
        this.countTicket = 0;
        this.currentTicket = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || totalEstimate + userStory.getEstimate() > capacity || countTicket >= ticketsLimit) {
            return false;
        }

        for (UserStory dependency : userStory.getDependencies()) {
            boolean found = false;
            for (int i = 0; i < countTicket; i++) {
                if (currentTicket[i] == dependency) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        currentTicket[countTicket++] = userStory;
        totalEstimate += userStory.getEstimate();
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted() || totalEstimate + bugReport.getEstimate() > capacity || countTicket >= ticketsLimit) {
            return false;
        }

        currentTicket[countTicket++] = bugReport;
        totalEstimate += bugReport.getEstimate();
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] result = new Ticket[countTicket];
        System.arraycopy(currentTicket, 0, result, 0, countTicket);
        return result;
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }
}