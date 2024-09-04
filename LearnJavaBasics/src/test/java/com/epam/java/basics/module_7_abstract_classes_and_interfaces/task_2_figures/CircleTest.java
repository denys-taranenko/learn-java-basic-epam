package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @ParameterizedTest
    @MethodSource("testAreaCases")
    void testArea(double area, Circle circle) {
        assertEquals(area, circle.area(), 0.0001);
    }

    @ParameterizedTest
    @MethodSource("testPointsCases")
    void testPoints(String expected, Circle circle) {
        assertEquals(expected, circle.pointsToString());
    }

    @ParameterizedTest
    @MethodSource("testToStringCases")
    void testToString(String expected, Circle circle) {
        assertEquals(expected, circle.toString());
    }

    @ParameterizedTest
    @MethodSource("testLeftmostCases")
    void testLeftmost(double expectedX, double expectedY, Circle circle) {
        assertEquals(expectedX, circle.leftmostPoint().x(), 0.0001);
        assertEquals(expectedY, circle.leftmostPoint().y(), 0.0001);
    }

    static Stream<Arguments> testAreaCases() {
        final Iterator<Double> areas = Arrays.asList(
                3.14159265358979323846,
                3.14159265358979323846,
                9852.03456165759,
                0.00000314159265358979323846,
                388.71633468071917).iterator();

        return circles()
                .map(c -> Arguments.of(areas.next(), c));
    }

    static Stream<Arguments> testPointsCases() {
        final Iterator<String> expected = Arrays.asList(
                "(0.0,0.0)",
                "(1.0,3.0)",
                "(-23.5,236.0)",
                "(-28.5,-2.0)",
                "(56.0,-87.0)").iterator();

        return circles()
                .map(c -> Arguments.of(expected.next(), c));
    }

    static Stream<Arguments> testToStringCases() {
        final Iterator<String> expected = Arrays.asList(
                "Circle[(0.0,0.0)1.0]",
                "Circle[(1.0,3.0)1.0]",
                "Circle[(-23.5,236.0)56.0]",
                "Circle[(-28.5,-2.0)0.001]",
                "Circle[(56.0,-87.0)11.1235]").iterator();
        return circles()
                .map(c -> Arguments.of(expected.next(), c));
    }


    static Stream<Arguments> testLeftmostCases() {
        final Iterator<Double> coords = Arrays.asList(
                -1.0, 0.0,
                0.0, 3.0,
                -79.5, 236.0,
                -28.501, -2.0,
                44.8765, -87.0
        ).iterator();
        return circles()
                .map(c -> Arguments.of(coords.next(), coords.next(), c));
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
