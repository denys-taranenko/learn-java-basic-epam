package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_3_figures_extra_challenge;

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
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuadrilateralTest {

    @Test
    void testConstructor() {
        q(0, 0, 0, 1, 1, 1, 1, 0);
        q(-2, 2, -3, 1, 0, 1, 0, 2);
    }


    @Test
    void testConstructorNullACase() {
        assertThrows(IllegalArgumentException.class, () -> q(null, new Point(-3, 1), new Point(0, 1), new Point(1, 9)));
    }

    @Test
    void testConstructorNullBCase() {
        assertThrows(IllegalArgumentException.class, () -> q(new Point(0, 1), null, new Point(-3, 1), new Point(9, 78)));
    }

    @Test
    void testConstructorNullCCase() {
        assertThrows(IllegalArgumentException.class, () -> q(new Point(-3, 1), new Point(0, 1), null, new Point(0, 0)));
    }

    @Test
    void testConstructorNullDCase() {
        assertThrows(IllegalArgumentException.class, () -> q(new Point(-3, 1), new Point(0, 1), new Point(0, 0), null));
    }

    @Test
    void testConstructorDegenerative1() {
        assertThrows(IllegalArgumentException.class, () -> q(-1, -1, 1, 1, 2, 2, 3, -3));
    }

    @Test
    void testConstructorDegenerative2() {
        assertThrows(IllegalArgumentException.class, () -> q(1, 3, 3, 9, 2, 6, -5, 5));
    }

    @Test
    void testConstructorDegenerative3() {
        assertThrows(IllegalArgumentException.class, () -> q(0, 0, 0, 2, 0, 5, 1, 1));
    }

    @Test
    void testConstructorDegenerative4() {
        assertThrows(IllegalArgumentException.class, () -> q(0, 0, 0, 0, 0, 5, 5, 0));
    }

    @Test
    void testConstructorNotPlain1() {
        assertThrows(IllegalArgumentException.class, () -> q(-1, 1, 1, -1, 1, 1, -1, -1));
    }

    @Test
    void testConstructorNotPlain2() {
        assertThrows(IllegalArgumentException.class, () -> q(-1, 1, -1, 0, 1, 0, 1, -1));
    }

    @Test
    void testConstructorNonConvex1() {
        assertThrows(IllegalArgumentException.class, () -> q(0, 0, 0, 10, 1, 1, 10, 0));
    }

    @Test
    void testConstructorNonConvex2() {
        assertThrows(IllegalArgumentException.class, () -> q(0, 0, 3, 3, 0, -3, -3, 3));
    }

    @Test
    void testTheSame() {

        Point a = new Point(0, 0);
        Point b = new Point(1, 10);
        Point c = new Point(11, 11);
        Point d = new Point(19, 2);

        final Quadrilateral abcd = q(a, b, c, d);
        final Quadrilateral abcd_clone = q(new Point(0, 0), new Point(1, 10), new Point(11, 11), new Point(19, 2));
        final Quadrilateral bcda = q(b, c, d, a);
        final Quadrilateral badc = q(b, a, d, c);
        final Quadrilateral cbad = q(c, b, a, d);

        assertTrue(abcd.isTheSame(abcd_clone));
        assertTrue(abcd.isTheSame(bcda));
        assertTrue(abcd.isTheSame(badc));
        assertTrue(abcd.isTheSame(cbad));

        assertTrue(abcd_clone.isTheSame(abcd));
        assertTrue(bcda.isTheSame(abcd));
        assertTrue(badc.isTheSame(abcd));
        assertTrue(cbad.isTheSame(abcd));

        assertFalse(abcd.isTheSame(q(a, b, c, new Point(d.x() + 1, d.y()))));
        assertFalse(abcd.isTheSame(q(a, new Point(-b.x(), b.y()), c, d)));

        assertTrue(abcd.isTheSame(q(a, b, c, new Point(d.x(), sqrt(2) * sqrt(2)))));
        assertTrue(abcd.isTheSame(q(c, new Point(d.x(), sqrt(2) * sqrt(2)), a, b)));
    }

    @ParameterizedTest
    @MethodSource("testCentroidCases")
    void testCentroid(final double expectedX, final double expectedY, final Quadrilateral q) {
        final Point centroid = q.centroid();
        assertEquals(expectedX, centroid.x(), 0.0001, "Error in centroid() on case " + q);
        assertEquals(expectedY, centroid.y(), 0.0001, "Error in centroid() on case " + q);
    }


    static Stream<Arguments> testCentroidCases() throws IOException {
        Iterator<String> it = Files.readAllLines(Paths.get("src/test/resources/figures/quadrilateral-centroid.txt")).iterator();
        return quadrilaterals()
                .map(q -> Arguments.of(parseDouble(it.next()), parseDouble(it.next()), q));
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
                        final Point p = q(a, b, c, d).centroid();
                        System.out.println(p.x());
                        System.out.println(p.y());
                    }
                }
            }
        }
        return quadrilaterals.build();
    }

    private static Quadrilateral q(final Point a, final Point b, final Point c, final Point d) {
        return new Quadrilateral(a, b, c, d);
    }

    private static void q(final double ax, final double ay, final double bx, final double by, final double cx, final double cy, final double dx, final double dy) {
        q(new Point(ax, ay), new Point(bx, by), new Point(cx, cy), new Point(dx, dy));
    }
}