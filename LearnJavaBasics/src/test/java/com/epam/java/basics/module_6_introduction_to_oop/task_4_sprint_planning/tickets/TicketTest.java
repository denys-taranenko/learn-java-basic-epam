package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.tickets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void testTicketGeneralApi() {
        Ticket ticket1 = new Ticket(345, "Cart Interface", 38);
        Ticket ticket2 = new Ticket(2568, "OAuth Integration", 65);

        assertEquals(345, ticket1.getId());
        assertEquals(38, ticket1.getEstimate());
        assertEquals("Cart Interface", ticket1.getName());

        assertEquals(2568, ticket2.getId());
        assertEquals(65, ticket2.getEstimate());
        assertEquals("OAuth Integration", ticket2.getName());

        assertFalse(ticket1.isCompleted());
        assertFalse(ticket2.isCompleted());

        ticket1.complete();

        assertTrue(ticket1.isCompleted());
        assertFalse(ticket2.isCompleted());

        ticket2.complete();

        assertTrue(ticket1.isCompleted());
        assertTrue(ticket2.isCompleted());
    }

    @Test
    void testComplete() {
        Ticket ticket1 = new Ticket(345, "Cart Interface", 38);

        assertFalse(ticket1.isCompleted());

        ticket1.complete();
        assertTrue(ticket1.isCompleted());
        ticket1.complete();
        assertTrue(ticket1.isCompleted());

        new Ticket(346, "Cart Interface", 38);

        ticket1.complete();
        assertTrue(ticket1.isCompleted());
    }
}