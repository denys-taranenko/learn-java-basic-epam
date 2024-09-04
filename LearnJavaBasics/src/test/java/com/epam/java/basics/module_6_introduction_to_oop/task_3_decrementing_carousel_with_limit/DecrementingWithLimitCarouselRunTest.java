package com.epam.java.basics.module_6_introduction_to_oop.task_3_decrementing_carousel_with_limit;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.CarouselRun;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecrementingWithLimitCarouselRunTest {


    @Test
    void testEmptyCase() {
        CarouselRun run = new DecrementingCarouselWithLimitedRun(7, 10).run();

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());
    }

    @Test
    void testHalfEmptyCase1() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(7, 10);

        carousel.addElement(3);
        carousel.addElement(7);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(3, run.next());
        assertEquals(7, run.next());
        assertEquals(4, run.next());

        assertEquals(2, run.next());
        assertEquals(6, run.next());
        assertEquals(3, run.next());

        assertEquals(1, run.next());
        assertEquals(5, run.next());
        assertEquals(2, run.next());

        assertEquals(4, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testHalfEmptyCase2() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(7, 7);

        carousel.addElement(7);
        carousel.addElement(3);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(3, run.next());
        assertEquals(4, run.next());

        assertEquals(6, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());

        assertEquals(5, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testFullCase1() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(5, 12);

        carousel.addElement(7);
        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(4, run.next());

        assertEquals(6, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());

        assertEquals(5, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testFullCase2() {
        DecrementingCarouselWithLimitedRun carousel = new DecrementingCarouselWithLimitedRun(6, 1000);

        carousel.addElement(7);
        carousel.addElement(2);
        carousel.addElement(100);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(2, run.next());
        assertEquals(100, run.next());
        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(4, run.next());

        assertEquals(6, run.next());
        assertEquals(1, run.next());
        assertEquals(99, run.next());
        assertEquals(2, run.next());
        assertEquals(3, run.next());

        assertEquals(5, run.next());
        assertEquals(98, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(4, run.next());
        assertEquals(97, run.next());
        assertEquals(1, run.next());

        assertEquals(3, run.next());
        assertEquals(96, run.next());
        assertEquals(2, run.next());
        assertEquals(95, run.next());
        assertEquals(1, run.next());
        assertEquals(94, run.next());

        for (int i = 93; i > 0; i--) {
            assertEquals(i, run.next());
        }
        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }
}