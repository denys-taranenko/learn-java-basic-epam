package com.epam.java.basics.module_6_introduction_to_oop.task_2_gradually_decreasing_carousel;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.CarouselRun;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraduallyDecreasingCarouselRunTest {

    @Test
    void testEmptyCase() {
        CarouselRun run = new GraduallyDecreasingCarousel(7).run();

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());
    }

    @Test
    void testHalfEmptyCase1() {
        GraduallyDecreasingCarousel carousel = new GraduallyDecreasingCarousel(7);

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

        assertEquals(4, run.next());
        assertEquals(1, run.next());

        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testHalfEmptyCase2() {
        GraduallyDecreasingCarousel carousel = new GraduallyDecreasingCarousel(7);

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

        assertEquals(4, run.next());
        assertEquals(1, run.next());

        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testFullCase1() {
        GraduallyDecreasingCarousel carousel = new GraduallyDecreasingCarousel(5);

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

        assertEquals(4, run.next());
        assertEquals(1, run.next());

        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testFullCase2() {
        GraduallyDecreasingCarousel carousel = new GraduallyDecreasingCarousel(6);

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

        assertEquals(4, run.next());
        assertEquals(97, run.next());
        assertEquals(1, run.next());

        assertEquals(1, run.next());
        assertEquals(94, run.next());

        assertEquals(90, run.next());
        assertEquals(85, run.next());
        assertEquals(79, run.next());
        assertEquals(72, run.next());
        assertEquals(64, run.next());
        assertEquals(55, run.next());
        assertEquals(45, run.next());
        assertEquals(34, run.next());
        assertEquals(22, run.next());
        assertEquals(9, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }
}