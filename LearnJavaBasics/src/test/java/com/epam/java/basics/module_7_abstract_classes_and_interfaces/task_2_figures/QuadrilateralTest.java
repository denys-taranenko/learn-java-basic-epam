package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_2_figures;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadrilateralTest {

    @Test
    void testConstructor() {
        q(0, 0, 0, 1, 1, 0);
        q(-2, 2, -3, 0, 0, 2);
    }


    @ParameterizedTest
    @MethodSource("testAreaCases")
    void testArea(final Quadrilateral q, final double expected) {
        assertEquals(expected, q.area(), 0.0001, "Error in area() on case " + q);
    }

    @ParameterizedTest
    @MethodSource("testToStringCases")
    void testToString(final Quadrilateral q, final String expected) {
        assertEquals(expected, q.toString(), "Error in toString() on case " + q);
    }

    @ParameterizedTest
    @MethodSource("testPointsCases")
    void testPoints(final Quadrilateral q, final String expected) {
        assertEquals(expected, q.pointsToString(), "Error in pointsToString() on case " + q);
    }

    @ParameterizedTest
    @MethodSource("testLeftmostCases")
    void testLeftmost(final Quadrilateral q, final double expected) {
        assertEquals(expected, q.leftmostPoint().x(), 0.0001, "Error in leftmostPoint() on case " + q);
    }

    static Stream<Arguments> testAreaCases() throws IOException {
        Iterator<String> areas = Files.readAllLines(Paths.get("src/test/resources/figures/quadrilateral-area.txt")).iterator();
        return quadrilaterals()
                .map(q -> Arguments.of(q, parseDouble(areas.next())));
    }

    static Stream<Arguments> testToStringCases() throws IOException {
        Iterator<String> areas = Files.readAllLines(Paths.get("src/test/resources/figures/quadrilateral-string.txt")).iterator();
        return quadrilaterals()
                .map(q -> Arguments.of(q, areas.next()));
    }

    static Stream<Arguments> testPointsCases() throws IOException {
        Iterator<String> areas = Files.readAllLines(Paths.get("src/test/resources/figures/quadrilateral-points.txt")).iterator();
        return quadrilaterals()
                .map(q -> Arguments.of(q, areas.next()));
    }

    static Stream<Arguments> testLeftmostCases() throws IOException {
        Iterator<String> expected = Files.readAllLines(Paths.get("src/test/resources/figures/quadrilateral-leftmost.txt")).iterator();
        return quadrilaterals()
                .map(q -> Arguments.of(q, parseDouble(expected.next())));
    }

    private static Stream<Quadrilateral> quadrilaterals() {

        Point[] p1 = new Point[]{
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 2),
                new Point(3, 4)
        };
        Point[] p2 = new Point[]{
                new Point(1, -1),
                new Point(2, -2),
                new Point(4, -2),
                new Point(3, -4)
        };
        Point[] p3 = new Point[]{
                new Point(-1, -1),
                new Point(-2, -2),
                new Point(-4, -2),
                new Point(-3, -4)
        };
        Point[] p4 = new Point[]{
                new Point(-1, 1),
                new Point(-2, 2),
                new Point(-4, 2),
                new Point(-3, 4)
        };

        final Stream.Builder<Quadrilateral> quadrilaterals = Stream.builder();
        for (Point a : p1) {
            for (Point b : p2) {
                for (Point c : p3) {
                    for (Point d : p4) {
                        quadrilaterals.add(q(a, b, c, d));
                    }
                }
            }
        }
        return quadrilaterals.build();
    }

    private static Quadrilateral q(final Point a, final Point b, final Point c, final Point d) {
        return new Quadrilateral(a, b, c, d);
    }

    private static void q(final double ax, final double ay, final double bx, final double cx, final double dx, final double dy) {
        q(new Point(ax, ay), new Point(bx, 1), new Point(cx, 1), new Point(dx, dy));
    }

}
