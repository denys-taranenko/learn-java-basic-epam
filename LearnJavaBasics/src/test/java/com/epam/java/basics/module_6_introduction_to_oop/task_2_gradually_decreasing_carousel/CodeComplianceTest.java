package com.epam.java.basics.module_6_introduction_to_oop.task_2_gradually_decreasing_carousel;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.DecrementingCarousel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeComplianceTest {

    @Test
    void testInheritance() {
        assertEquals(DecrementingCarousel.class, GraduallyDecreasingCarousel.class.getSuperclass());
    }
}