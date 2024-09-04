package com.epam.java.basics.module_6_introduction_to_oop.task_1_halving_carousel;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.CarouselRun;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HalvingCarouselRunTest {

    @Test
    void testEmptyCase() {
        CarouselRun run = new HalvingCarousel(7).run();

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());

        assertTrue(run.isFinished());
        assertEquals(-1, run.next());
        assertEquals(-1, run.next());
    }

    @Test
    void testHalfEmptyCase1() {
        HalvingCarousel carousel = new HalvingCarousel(7);

        carousel.addElement(3);
        carousel.addElement(7);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(3, run.next());
        assertEquals(7, run.next());
        assertEquals(4, run.next());

        assertEquals(1, run.next());
        assertEquals(3, run.next());
        assertEquals(2, run.next());


        assertEquals(1, run.next());
        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testHalfEmptyCase2() {
        HalvingCarousel carousel = new HalvingCarousel(7);

        carousel.addElement(7);
        carousel.addElement(3);
        carousel.addElement(4);
        CarouselRun run = carousel.run();

        assertEquals(7, run.next());
        assertEquals(3, run.next());
        assertEquals(4, run.next());

        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(1, run.next());
        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testFullCase1() {
        HalvingCarousel carousel = new HalvingCarousel(5);

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

        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(1, run.next());
        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }

    @Test
    void testFullCase2() {
        HalvingCarousel carousel = new HalvingCarousel(6);

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

        assertEquals(3, run.next());
        assertEquals(1, run.next());
        assertEquals(50, run.next());
        assertEquals(1, run.next());
        assertEquals(2, run.next());

        assertEquals(1, run.next());
        assertEquals(25, run.next());
        assertEquals(1, run.next());

        assertEquals(12, run.next());

        assertEquals(6, run.next());
        assertEquals(3, run.next());
        assertEquals(1, run.next());

        assertEquals(-1, run.next());
        assertTrue(run.isFinished());
    }
}