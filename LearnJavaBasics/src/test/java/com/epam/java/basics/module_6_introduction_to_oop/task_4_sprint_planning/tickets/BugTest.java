package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BugTest {

    @Test
    void testGeneralApi() {

        UserStory userStory = new UserStory(1, "OAuth Integration", 40);

        assertNull(Bug.createBug(345, "Github Token Problem", 8, userStory));
        assertNull(Bug.createBug(346, "Gitlab Token Problem", 8, userStory));

        userStory.complete();

        Bug bug1 = Bug.createBug(345, "Github Token Problem", 8, userStory);
        Bug bug2 = Bug.createBug(346, "Github Token Problem", 12, userStory);

        assertEquals(345, bug1.getId());
        assertEquals(8, bug1.getEstimate());
        assertEquals("Github Token Problem", bug1.getName());

        assertEquals(346, bug2.getId());
        assertEquals(12, bug2.getEstimate());
        assertEquals("Github Token Problem", bug2.getName());

        assertFalse(bug1.isCompleted());
        assertFalse(bug2.isCompleted());

        bug1.complete();

        assertTrue(bug1.isCompleted());
        assertFalse(bug2.isCompleted());

        bug2.complete();

        assertTrue(bug1.isCompleted());
        assertTrue(bug2.isCompleted());
    }

    @Test
    void testSimpleComplete() {
        UserStory userStory = new UserStory(1, "OAuth Integration", 40);
        userStory.complete();
        Bug bug1 = Bug.createBug(345, "Github Token Problem", 8, userStory);

        assertFalse(bug1.isCompleted());

        bug1.complete();
        assertTrue(bug1.isCompleted());
        bug1.complete();
        assertTrue(bug1.isCompleted());
    }

    @Test
    void testToString() {
        UserStory us1 = new UserStory(1, "User Story 1", 11);
        UserStory us2 = new UserStory(2, "User Story 2", 22);

        us1.complete();
        us2.complete();

        Bug bug13 = Bug.createBug(3, "Bug 13", 8, us1);
        Bug bug14 = Bug.createBug(4, "Bug 14", 8, us1);
        Bug bug25 = Bug.createBug(5, "Bug 25", 8, us2);

        assertEquals("[Bug 3] User Story 1: Bug 13", bug13.toString());
        assertEquals("[Bug 4] User Story 1: Bug 14", bug14.toString());
        assertEquals("[Bug 5] User Story 2: Bug 25", bug25.toString());
    }
}