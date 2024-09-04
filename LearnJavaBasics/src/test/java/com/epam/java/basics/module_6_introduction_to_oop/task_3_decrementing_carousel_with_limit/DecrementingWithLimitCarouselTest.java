package com.epam.java.basics.module_6_introduction_to_oop.task_3_decrementing_carousel_with_limit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecrementingWithLimitCarouselTest {

    @Test
    void checkAddElement() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(5, 10);
        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-1));
        assertFalse(carousel.addElement(-123456));
        assertFalse(carousel.addElement(0));

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));

        assertTrue(carousel.addElement(1234));
        assertTrue(carousel.addElement(1234));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-456));

        assertTrue(carousel.addElement(22));

        assertFalse(carousel.addElement(22));

        assertFalse(carousel.addElement(-856));
        assertFalse(carousel.addElement(0));

        assertFalse(carousel.addElement(357));
        assertFalse(carousel.addElement(159));
        assertFalse(carousel.addElement(1));
    }

    @Test
    void checkAddElementAfterRun() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(5, 10);

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));
        assertTrue(carousel.addElement(3));

        carousel.run();

        assertFalse(carousel.addElement(4));
        assertFalse(carousel.addElement(5));
        assertFalse(carousel.addElement(6));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));
        assertFalse(carousel.addElement(-4568));
    }

    @Test
    void testCarouselRunsSingleTimeOnly() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(4, 10);
        carousel.addElement(4);

        assertNotNull(carousel.run());
        assertNull(carousel.run());
        assertNull(carousel.run());
    }
}