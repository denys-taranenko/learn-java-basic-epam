package com.epam.java.basics.module_5_classes.task_3_triangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @Test
    void testConstructor() {
        new Triangle(new Point(0, 0), new Point(1, 1), new Point(0, 1));
        new Triangle(new Point(-2, 2), new Point(-3, 1), new Point(0, 1));
    }

    @Test
    void testConstructorNullACase() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(null, new Point(-3, 1), new Point(0, 1)));
    }


    @Test
    void testConstructorNullBCase() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(new Point(0, 1), null, new Point(-3, 1)));
    }

    @Test
    void testConstructorNullCCase() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(new Point(-3, 1), new Point(0, 1), null));
    }

    @Test
    void testConstructorDegenerative1() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(new Point(-1, -1), new Point(1, 1), new Point(3, 3)));
    }

    @Test
    void testConstructorDegenerative2() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(new Point(1, 3), new Point(3, 9), new Point(2, 6)));
    }

    @Test
    void testConstructorDegenerative3() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(new Point(0, 0), new Point(0, 2), new Point(0, 5)));
    }

    @Test
    void testConstructorDegenerative4() {
        assertThrows(RuntimeException.class, () ->
                new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 5)));
    }

    @ParameterizedTest
    @MethodSource
    void testArea(final double expected, final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        assertEquals(expected, t.area(), 0.0001, () -> "Error in area() on case " + triangleToString(ax, ay, bx, by, cx, cy));
    }

    @ParameterizedTest
    @MethodSource
    void testCentroid(final double ax, final double ay, final double bx, final double by, final double cx, final double cy, final Point expected) {
        final Triangle t = t(ax, ay, bx, by, cx, cy);
        assertEquals(expected.x(), t.centroid().x(), 0.0001, () -> "Error in centroid() on case (X) " + triangleToString(ax, ay, bx, by, cx, cy));
        assertEquals(expected.y(), t.centroid().y(), 0.0001, () -> "Error in centroid() on case (Y) " + triangleToString(ax, ay, bx, by, cx, cy));
    }

    static Stream<Arguments> testArea() {
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

    static Stream<Arguments> testCentroid() {
        return Stream.of(
                Arguments.of(0, 0, 4, 0, 0, 3, new Point(1.3333333333333333, 1.0)),
                Arguments.of(0, 1, 0, 4, 3, 0, new Point(1.0, 1.6666666666666667)),
                Arguments.of(2, 5, -5, 4, 3, 0, new Point(0.0, 3.0)),
                Arguments.of(8, 2, 1, 2, -2, -8, new Point(2.3333333333333335, -1.3333333333333333)),
                Arguments.of(4, 5, 2, 5, 3, -8, new Point(3.0, 0.6666666666666666)),
                Arguments.of(9, 7, 6, 9, 7, -8, new Point(7.333333333333333, 2.6666666666666665)),
                Arguments.of(4, 9, 4, 6, 9, -8, new Point(5.666666666666667, 2.3333333333333335)),
                Arguments.of(6, 3, 7, 3, -3, -7, new Point(3.3333333333333335, -0.3333333333333333)),
                Arguments.of(3, 5, 9, 3, 6, 5, new Point(6.0, 4.333333333333333)),
                Arguments.of(8, 2, 3, 7, 3, 3, new Point(4.666666666666667, 4.0)),
                Arguments.of(7, 7, 4, 0, 5, 5, new Point(5.333333333333333, 4.0)),
                Arguments.of(3, 4, 8, 2, 6, 9, new Point(5.666666666666667, 5.0))
        );
    }

    private Triangle t(final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        return new Triangle(new Point(ax, ay), new Point(bx, by), new Point(cx, cy));
    }

    private String triangleToString(final double ax, final double ay, final double bx, final double by, final double cx, final double cy) {
        return new StringJoiner(";", "[", "]")
                .add(new StringJoiner(";", "(", ")")
                        .add(Double.toString(ax))
                        .add(Double.toString(ay))
                        .toString())
                .add(new StringJoiner(";", "(", ")")
                        .add(Double.toString(bx))
                        .add(Double.toString(by))
                        .toString())
                .add(new StringJoiner(";", "(", ")")
                        .add(Double.toString(cx))
                        .add(Double.toString(cy))
                        .toString())
                .toString();
    }
}