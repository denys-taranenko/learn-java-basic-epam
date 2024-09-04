package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserStoryTest {

    @Test
    void testGeneralApi() {
        UserStory us1 = new UserStory(345, "Cart Interface", 38);
        UserStory us2 = new UserStory(2568, "OAuth Integration", 65);

        assertEquals(345, us1.getId());
        assertEquals(38, us1.getEstimate());
        assertEquals("Cart Interface", us1.getName());

        assertEquals(2568, us2.getId());
        assertEquals(65, us2.getEstimate());
        assertEquals("OAuth Integration", us2.getName());

        assertFalse(us1.isCompleted());
        assertFalse(us2.isCompleted());

        us1.complete();

        assertTrue(us1.isCompleted());
        assertFalse(us2.isCompleted());

        us2.complete();

        assertTrue(us1.isCompleted());
        assertTrue(us2.isCompleted());
    }

    @Test
    void testDependencies() {
        UserStory us1 = new UserStory(1, "User Story 1", 11);
        UserStory us2 = new UserStory(2, "User Story 2", 22);
        UserStory us3 = new UserStory(3, "User Story 3", 33, us1, us2);

        assertEquals(0, us1.getDependencies().length);
        assertEquals(0, us2.getDependencies().length);

        UserStory[] us3Dependencies = us3.getDependencies();
        assertTrue(Arrays.deepEquals(
                new UserStory[]{us1, us2},
                us3Dependencies
        ));
    }

    @Test
    void testDependenciesDefensiveCopy() {
        UserStory us1 = new UserStory(1, "User Story 1", 11);
        UserStory us2 = new UserStory(2, "User Story 2", 22);
        UserStory us3 = new UserStory(3, "User Story 3", 33, us1, us2);

        us3.getDependencies()[0] = null;

        UserStory[] us3Dependencies = us3.getDependencies();
        assertTrue(Arrays.deepEquals(
                new UserStory[]{us1, us2},
                us3Dependencies
        ));
    }

    @Test
    void testSimpleComplete() {
        UserStory userStory = new UserStory(345, "Cart Interface", 38);

        assertFalse(userStory.isCompleted());

        userStory.complete();
        assertTrue(userStory.isCompleted());
        userStory.complete();
        assertTrue(userStory.isCompleted());

        new UserStory(346, "Cart Interface", 38);

        userStory.complete();
        assertTrue(userStory.isCompleted());
    }

    @Test
    void testCompleteWithDependencies() {

        UserStory us1 = new UserStory(1, "User Story 1", 11);
        UserStory us2 = new UserStory(2, "User Story 2", 22, us1);
        UserStory us3 = new UserStory(3, "User Story 3", 33);
        UserStory us4 = new UserStory(4, "User Story 4", 44, us2, us3);

        assertFalse(us2.isCompleted());
        us2.complete();
        assertFalse(us1.isCompleted());


        assertFalse(us4.isCompleted());
        us4.complete();
        assertFalse(us4.isCompleted());

        us1.complete();

        assertFalse(us2.isCompleted());
        us2.complete();
        assertTrue(us2.isCompleted());

        assertFalse(us4.isCompleted());
        us4.complete();
        assertFalse(us4.isCompleted());

        us3.complete();

        assertFalse(us4.isCompleted());
        us4.complete();
        assertTrue(us4.isCompleted());
    }

    @Test
    void testToString() {
        UserStory us1 = new UserStory(1, "User Story 1", 11);
        UserStory us2 = new UserStory(2, "User Story 2", 22);
        UserStory us3 = new UserStory(3, "User Story 3", 33, us1, us2);

        assertEquals("[US 1] User Story 1", us1.toString());
        assertEquals("[US 2] User Story 2", us2.toString());
        assertEquals("[US 3] User Story 3", us3.toString());
    }
}