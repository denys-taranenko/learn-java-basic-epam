package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_3_figures_extra_challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircleTest {

    @Test
    void testConstructor() {
        Figure circle = null;
        circle = new Circle(new Point(0, 0), 1);
        circle = new Circle(new Point(1, 3), 1);
        circle = new Circle(new Point(-23.5, 236), 56);
        circle = new Circle(new Point(-28.5, -2), 0.001);
        circle = new Circle(new Point(56, -87), 11.1235);

        assertNotNull(circle);
    }

    @Test
    void testConstructorZeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(new Point(0, 0), 0));
    }

    @Test
    void testConstructorNegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(new Point(5, -6), -23));
    }

    @Test
    void testConstructorNullCenter() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(null, 23));
    }


    @ParameterizedTest
    @MethodSource("testCentroidCases")
    void testCentroid(double expectedX, double expectedY, Circle circle) {
        assertEquals(expectedX, circle.centroid().x(), 0.0001);
        assertEquals(expectedY, circle.centroid().y(), 0.0001);
    }

    static Stream<Arguments> testCentroidCases() {
        final Iterator<Double> coords = Arrays.asList(
                0.0, 0.0,
                1.0, 3.0,
                -23.5, 236.0,
                -28.5, -2.0,
                56.0, -87.0
        ).iterator();
        return circles()
                .map(c -> Arguments.of(coords.next(), coords.next(), c));

    }

    @Test
    void testisTheSame() {
        assertTrue(new Circle(new Point(0, 0), 1).isTheSame(new Circle(new Point(0, 0), 1)));
        assertTrue(new Circle(new Point(1 - (1d / 3 * 3), 3 - (30d / 10)), 1).isTheSame(new Circle(new Point(0, 0), 1)));
        Point center = new Point(sqrt(2) * sqrt(2), 4 - sqrt(2) * sqrt(2));
        assertTrue(new Circle(center, sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2, 2), 3)));

        assertFalse(new Circle(center, sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2.1, 2), 3)));
        assertFalse(new Circle(center, sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2, 2), 2.9)));
        assertFalse(new Circle(center, sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2, -2.0), 3)));

        assertFalse(new Circle(new Point(0, 0), 1).isTheSame(new Triangle(new Point(0, 1), new Point(1, 1), new Point(1, 0))));
        assertFalse(new Circle(new Point(0, 0), 1).isTheSame(new Quadrilateral(new Point(0, 1), new Point(1, 1), new Point(1, 0), new Point(0, 0))));
    }

    private static Stream<Circle> circles() {
        return Stream.of(
                new Circle(new Point(0, 0), 1),
                new Circle(new Point(1, 3), 1),
                new Circle(new Point(-23.5, 236), 56),
                new Circle(new Point(-28.5, -2), 0.001),
                new Circle(new Point(56, -87), 11.1235)
        );
    }
}