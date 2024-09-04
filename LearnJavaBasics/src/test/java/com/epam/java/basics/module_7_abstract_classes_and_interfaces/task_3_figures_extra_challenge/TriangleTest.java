package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_3_figures_extra_challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @Test
    void testConstructor() {
        t(0, 0, 1, 1, 0, 1);
        t(-2, 2, -3, 1, 0, 1);
    }


    @Test
    void testConstructorNullCase() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(null, new Point(-3, 1), new Point(0, 1)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(new Point(0, 1), null, new Point(-3, 1)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(new Point(-3, 1), new Point(0, 1), null));
    }

    @Test
    void testConstructorDegenerative1() {
        assertThrows(IllegalArgumentException.class, () -> t(-1, -1, 1, 1, 2, 2));
        assertThrows(IllegalArgumentException.class, () -> t(1, 3, 3, 9, 2, 6));
        assertThrows(IllegalArgumentException.class, () -> t(0, 0, 0, 2, 0, 5));
        assertThrows(IllegalArgumentException.class, () -> t(0, 0, 0, 2, 0, 5));
        assertThrows(IllegalArgumentException.class, () -> t(0, 0, 0, 0, 0, 5));
    }


    @ParameterizedTest
    @MethodSource("testCentroidCases")
    void testCentroid(final double expectedX, final double expectedY, final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        final Point centroid = t.centroid();
        assertEquals(expectedX, centroid.x(), 0.0001, "Error in centroid() on case " + t);
        assertEquals(expectedY, centroid.y(), 0.0001, "Error in centroid() on case " + t);
    }

    static Stream<Arguments> testCentroidCases() {
        return Stream.of(
                Arguments.of(1.3333333333333333, 1, 0, 0, 4, 0, 0, 3),
                Arguments.of(1, 1.6666666666666667, 0, 1, 0, 4, 3, 0),
                Arguments.of(0, 3, 2, 5, -5, 4, 3, 0),
                Arguments.of(2.3333333333333335, -1.3333333333333333, 8, 2, 1, 2, -2, -8),
                Arguments.of(3, 0.6666666666666666, 4, 5, 2, 5, 3, -8),
                Arguments.of(7.333333333333333, 2.6666666666666665, 9, 7, 6, 9, 7, -8),
                Arguments.of(5.666666666666667, 2.3333333333333335, 4, 9, 4, 6, 9, -8),
                Arguments.of(3.3333333333333335, -0.3333333333333333, 6, 3, 7, 3, -3, -7),
                Arguments.of(6, 4.333333333333333, 3, 5, 9, 3, 6, 5),
                Arguments.of(4.666666666666667, 4, 8, 2, 3, 7, 3, 3),
                Arguments.of(5.333333333333333, 4, 7, 7, 4, 0, 5, 5),
                Arguments.of(5.666666666666667 , 5, 3, 4, 8, 2, 6, 9)
        );
    }

    private Triangle t(final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        return new Triangle(new Point(ax, ay), new Point(bx, by), new Point(cx, cy));
    }
}