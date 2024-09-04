package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    public void testConstructor() {
        t(0, 0, 1, 1, 0, 1);
        t(-2, 2, -3, 1, 0, 1);
    }

    @ParameterizedTest
    @MethodSource("testAreaCases")
    void testArea(final double expected, final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        assertEquals(expected, t.area(), 0.0001, "Error in area() on case " + t);
    }

    @ParameterizedTest
    @MethodSource("testToStringCases")
    void testToString(final String expected, final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        assertEquals(expected, t.toString(), "Error in toString() on case " + t);
    }

    @ParameterizedTest
    @MethodSource("testPointsCases")
    void testPoints(final String expected, final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        assertEquals(expected, t.pointsToString(), "Error in pointsToString() on case " + t);
    }

    @ParameterizedTest
    @MethodSource("testLeftmostCases")
    void testLeftmost(final double expected, final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        assertEquals(expected, t.leftmostPoint().x(), 0.0001, "Error in leftmostPoint() on case " + t);
    }

    static Stream<Arguments> testAreaCases() {
        return Stream.of(
                Arguments.of(6.00, 0, 0, 4, 0, 0, 3),
                Arguments.of(4.50, 0, 1, 0, 4, 3, 0),
                Arguments.of(18.0, 2, 5, -5, 4, 3, 0),
                Arguments.of(35.0, 8, 2, 1, 2, -2, -8),
                Arguments.of(13.0, 4, 5, 2, 5, 3, -8),
                Arguments.of(24.5, 9, 7, 6, 9, 7, -8),
                Arguments.of(7.50, 4, 9, 4, 6, 9, -8),
                Arguments.of(5.00, 6, 3, 7, 3, -3, -7),
                Arguments.of(3.00, 3, 5, 9, 3, 6, 5),
                Arguments.of(10.0, 8, 2, 3, 7, 3, 3),
                Arguments.of(4.00, 7, 7, 4, 0, 5, 5),
                Arguments.of(15.5, 3, 4, 8, 2, 6, 9)
        );
    }

    static Stream<Arguments> testToStringCases() {
        return Stream.of(
                Arguments.of("Triangle[(0.0,0.0)(4.0,0.0)(0.0,3.0)]", 0, 0, 4, 0, 0, 3),
                Arguments.of("Triangle[(0.0,1.0)(0.0,4.0)(3.0,0.0)]", 0, 1, 0, 4, 3, 0),
                Arguments.of("Triangle[(2.0,5.0)(-5.0,4.0)(3.0,0.0)]", 2, 5, -5, 4, 3, 0),
                Arguments.of("Triangle[(8.0,2.0)(1.0,2.0)(-2.0,-8.0)]", 8, 2, 1, 2, -2, -8),
                Arguments.of("Triangle[(4.0,5.0)(2.0,5.0)(3.0,-8.0)]", 4, 5, 2, 5, 3, -8),
                Arguments.of("Triangle[(9.0,7.0)(6.0,9.0)(7.0,-8.0)]", 9, 7, 6, 9, 7, -8),
                Arguments.of("Triangle[(4.0,9.0)(4.0,6.0)(9.0,-8.0)]", 4, 9, 4, 6, 9, -8),
                Arguments.of("Triangle[(6.0,3.0)(7.0,3.0)(-3.0,-7.0)]", 6, 3, 7, 3, -3, -7),
                Arguments.of("Triangle[(3.0,5.0)(9.0,3.0)(6.0,5.0)]", 3, 5, 9, 3, 6, 5),
                Arguments.of("Triangle[(8.0,2.0)(3.0,7.0)(3.0,3.0)]", 8, 2, 3, 7, 3, 3),
                Arguments.of("Triangle[(7.0,7.0)(4.0,0.0)(5.0,5.0)]", 7, 7, 4, 0, 5, 5),
                Arguments.of("Triangle[(3.0,4.0)(8.0,2.0)(6.0,9.0)]", 3, 4, 8, 2, 6, 9)
        );
    }

    static Stream<Arguments> testPointsCases() {
        return Stream.of(
                Arguments.of("(0.0,0.0)(4.0,0.0)(0.0,3.0)", 0, 0, 4, 0, 0, 3),
                Arguments.of("(0.0,1.0)(0.0,4.0)(3.0,0.0)", 0, 1, 0, 4, 3, 0),
                Arguments.of("(2.0,5.0)(-5.0,4.0)(3.0,0.0)", 2, 5, -5, 4, 3, 0),
                Arguments.of("(8.0,2.0)(1.0,2.0)(-2.0,-8.0)", 8, 2, 1, 2, -2, -8),
                Arguments.of("(4.0,5.0)(2.0,5.0)(3.0,-8.0)", 4, 5, 2, 5, 3, -8),
                Arguments.of("(9.0,7.0)(6.0,9.0)(7.0,-8.0)", 9, 7, 6, 9, 7, -8),
                Arguments.of("(4.0,9.0)(4.0,6.0)(9.0,-8.0)", 4, 9, 4, 6, 9, -8),
                Arguments.of("(6.0,3.0)(7.0,3.0)(-3.0,-7.0)", 6, 3, 7, 3, -3, -7),
                Arguments.of("(3.0,5.0)(9.0,3.0)(6.0,5.0)", 3, 5, 9, 3, 6, 5),
                Arguments.of("(8.0,2.0)(3.0,7.0)(3.0,3.0)", 8, 2, 3, 7, 3, 3),
                Arguments.of("(7.0,7.0)(4.0,0.0)(5.0,5.0)", 7, 7, 4, 0, 5, 5),
                Arguments.of("(3.0,4.0)(8.0,2.0)(6.0,9.0)", 3, 4, 8, 2, 6, 9)
        );
    }

    static Stream<Arguments> testLeftmostCases() {
        return Stream.of(
                Arguments.of(0, 0, 0, 4, 0, 0, 3),
                Arguments.of(0, 0, 1, 0, 4, 3, 0),
                Arguments.of(-5, 2, 5, -5, 4, 3, 0),
                Arguments.of(-2, 8, 2, 1, 2, -2, -8),
                Arguments.of(2, 4, 5, 2, 5, 3, -8),
                Arguments.of(6, 9, 7, 6, 9, 7, -8),
                Arguments.of(4, 4, 9, 4, 6, 9, -8),
                Arguments.of(-3, 6, 3, 7, 3, -3, -7),
                Arguments.of(3, 3, 5, 9, 3, 6, 5),
                Arguments.of(3, 8, 2, 3, 7, 3, 3),
                Arguments.of(4, 7, 7, 4, 0, 5, 5),
                Arguments.of(3, 3, 4, 8, 2, 6, 9)
        );
    }

    private Triangle t(final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        return new Triangle(new Point(ax, ay), new Point(bx, by), new Point(cx, cy));
    }

}
