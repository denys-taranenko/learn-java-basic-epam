package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning;

import com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets.Bug;
import com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets.Ticket;
import com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets.UserStory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SprintTest {

    @Test
    void testRegularPositiveCaseWithUserStories() {
        int nextId = 1;
        Sprint sprint = new Sprint(40, 3);

        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Entity", 8)));
        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Form", 16)));
        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration. Apply Captcha", 16)));

        Ticket[] tickets = sprint.getTickets();

        assertEquals(3, tickets.length);
        assertEquals(tickets[0].toString(), "[US 1] User Registration Entity");
        assertEquals(tickets[1].toString(), "[US 2] User Registration Form");
        assertEquals(tickets[2].toString(), "[US 3] User Registration. Apply Captcha");

        assertEquals(40, sprint.getTotalEstimate());
    }

    @Test
    void testRegularPositiveCaseWithBugs() {
        int nextId = 1;

        Sprint sprint = new Sprint(40, 3);

        UserStory userStory = new UserStory(nextId++, "Registration Form", 16);
        userStory.complete();

        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Add password repeat", 8, userStory)));
        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Apply validation", 8, userStory)));
        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Add hide/show button for password", 8, userStory)));

        Ticket[] tickets = sprint.getTickets();
        assertEquals(3, tickets.length);
        assertEquals(tickets[0].toString(), "[Bug 2] Registration Form: Add password repeat");
        assertEquals(tickets[1].toString(), "[Bug 3] Registration Form: Apply validation");
        assertEquals(tickets[2].toString(), "[Bug 4] Registration Form: Add hide/show button for password");

        assertEquals(24, sprint.getTotalEstimate());
    }

    @Test
    void testCaseWithCapacityOverflow() {
        Sprint sprint = new Sprint(10, 30);

        int nextId = 1;

        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Entity", 8)));
        assertFalse(sprint.addUserStory(new UserStory(nextId++, "User Registration Form", 16)));
        assertFalse(sprint.addUserStory(new UserStory(nextId++, "User Registration. Apply Captcha", 16)));

        Ticket[] tickets = sprint.getTickets();
        assertEquals(1, tickets.length);
        assertEquals(tickets[0].toString(), "[US 1] User Registration Entity");

        assertEquals(8, sprint.getTotalEstimate());
    }

    @Test
    void testCaseWithCapacityOverflowBugs() {
        int nextId = 1;

        Sprint sprint = new Sprint(20, 3);

        UserStory userStory = new UserStory(nextId++, "Registration Form", 16);
        userStory.complete();

        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Add password repeat", 8, userStory)));
        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Apply validation", 10, userStory)));
        assertFalse(sprint.addBug(Bug.createBug(nextId++, "Add hide/show button for password", 8, userStory)));

        Ticket[] tickets = sprint.getTickets();
        assertEquals(2, tickets.length);
        assertEquals(tickets[0].toString(), "[Bug 2] Registration Form: Add password repeat");
        assertEquals(tickets[1].toString(), "[Bug 3] Registration Form: Apply validation");

        assertEquals(18, sprint.getTotalEstimate());
    }

    @Test
    void testCaseWithLimitOverflow() {
        Sprint sprint = new Sprint(1000, 2);

        int nextId = 1;

        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Entity", 8)));
        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Form", 16)));
        assertFalse(sprint.addUserStory(new UserStory(nextId++, "User Registration. Apply Captcha", 16)));

        Ticket[] tickets = sprint.getTickets();
        assertEquals(2, tickets.length);
        assertEquals(tickets[0].toString(), "[US 1] User Registration Entity");
        assertEquals(tickets[1].toString(), "[US 2] User Registration Form");

        assertEquals(24, sprint.getTotalEstimate());
    }

    @Test
    void testCaseWithLimitOverflowBugs() {
        int nextId = 1;

        Sprint sprint = new Sprint(200, 3);

        UserStory userStory = new UserStory(nextId++, "Registration Form", 16);
        userStory.complete();

        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Add password repeat", 8, userStory)));
        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Apply validation", 10, userStory)));
        assertTrue(sprint.addBug(Bug.createBug(nextId++, "Add hide/show button for password", 8, userStory)));
        assertFalse(sprint.addBug(Bug.createBug(nextId++, "Add hide/show button for password", 8, userStory)));

        Ticket[] tickets = sprint.getTickets();
        assertEquals(3, tickets.length);
        assertEquals(tickets[0].toString(), "[Bug 2] Registration Form: Add password repeat");
        assertEquals(tickets[1].toString(), "[Bug 3] Registration Form: Apply validation");
        assertEquals(tickets[2].toString(), "[Bug 4] Registration Form: Add hide/show button for password");

        assertEquals(26, sprint.getTotalEstimate());
    }

    @Test
    void testTicketsDefensiveCopy() {
        int nextId = 1;
        Sprint sprint = new Sprint(40, 3);

        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Entity", 8)));
        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration Form", 16)));
        assertTrue(sprint.addUserStory(new UserStory(nextId++, "User Registration. Apply Captcha", 16)));

        sprint.getTickets()[1] = null;
        sprint.getTickets()[2] = (new UserStory(nextId++, "Another Story", 4));

        Ticket[] tickets = sprint.getTickets();

        assertEquals(3, tickets.length);
        assertEquals(tickets[0].toString(), "[US 1] User Registration Entity");
        assertEquals(tickets[1].toString(), "[US 2] User Registration Form");
        assertEquals(tickets[2].toString(), "[US 3] User Registration. Apply Captcha");

        assertEquals(40, sprint.getTotalEstimate());
    }

    @Test
    void testCaseWithDependencies() {
        int nextId = 1;
        Sprint sprint = new Sprint(40, 3);

        UserStory us1 = new UserStory(nextId++, "User Registration Entity", 8);
        UserStory us2 = new UserStory(nextId++, "User Registration Form", 16, us1);
        UserStory us3 = new UserStory(nextId++, "User Registration. Apply Captcha", 16, us1, us2);

        assertFalse(sprint.addUserStory(us2));
        assertFalse(sprint.addUserStory(us3));

        assertTrue(sprint.addUserStory(us1));
        assertFalse(sprint.addUserStory(us3));

        assertTrue(sprint.addUserStory(us2));
        assertTrue(sprint.addUserStory(us3));
    }

    @Test
    void testAddNullAndCompleted() {
        int nextId = 1;
        Sprint sprint = new Sprint(40, 30);

        UserStory us1 = new UserStory(nextId++, "User Registration Entity", 8);
        UserStory us2 = new UserStory(nextId++, "User Registration Form", 8);

        us1.complete();

        Bug bug1 = Bug.createBug(nextId++, "Bug 1", 4, us1);
        Bug bug2 = Bug.createBug(nextId++, "Bug 2", 4, us1);

        bug1.complete();

        assertFalse(sprint.addUserStory(null));
        assertFalse(sprint.addUserStory(us1));
        assertFalse(sprint.addBug(null));
        assertFalse(sprint.addBug(bug1));

        assertTrue(sprint.addUserStory(us2));
        assertTrue(sprint.addBug(bug2));
    }
}