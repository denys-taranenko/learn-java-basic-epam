package com.epam.java.basics.module_5_classes.task_2_segments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SegmentTest {

    @Test
    void testConstructor() {
        new Segment(new Point(0, 0), new Point(1, 1));
        new Segment(new Point(-2, 2), new Point(-3, 1));
    }

    @Test
    void testConstructorSameStartEndCase() {
        assertThrows(RuntimeException.class, () -> {
            Point p = new Point(3, 7);
            new Segment(p, p);
        });
    }

    @Test
    void testConstructorEqualStartEndCase() {
        assertThrows(RuntimeException.class, () -> new Segment(new Point(3, 7), new Point(3, 7)));
    }

    @Test
    void testConstructorNullStartCase() {
        assertThrows(RuntimeException.class, () -> new Segment(null, new Point(3, 7)));
    }

    @Test
    void testConstructorNullEndCase() {
        assertThrows(RuntimeException.class, () -> new Segment(new Point(3, 7), null));
    }

    @Test
    void testConstructorNullStartEndCase() {
        assertThrows(RuntimeException.class, () -> new Segment(null, null));
    }

    @ParameterizedTest
    @MethodSource("lengthTestCases")
    void testLength(final Point start, final Point end, final double expected) {
        double length = new Segment(start, end).length();
        assertEquals(expected, length, 0.001, "Error on " + segmentCaseToString(start, end));
    }

    @ParameterizedTest
    @MethodSource("middleTestCases")
    void testMiddle(final Point expected, final Segment segment) {
        final Point actual = segment.middle();
        assertEquals(expected.x(), actual.x(), 0.001);
        assertEquals(expected.y(), actual.y(), 0.001);
    }

    @ParameterizedTest
    @MethodSource("intersectionTestCases")
    void testIntersection(final Segment a, final Segment b, final Point expected) {
        final Point actual = a.intersection(b);
        if (expected == null) {
            assertNull(actual);
            return;
        }
        assertNotNull(actual);
        assertEquals(expected.x(), actual.x(), 0.001);
        assertEquals(expected.y(), actual.y(), 0.001);
    }

    static Stream<Arguments> lengthTestCases() {
        return Stream.of(
                Arguments.of(new Point(0, 0), new Point(3, 4), 5),
                Arguments.of(new Point(3, 4), new Point(0, 0), 5),
                Arguments.of(new Point(-3, 4), new Point(0, 0), 5),
                Arguments.of(new Point(-3, -4), new Point(0, 0), 5),
                Arguments.of(new Point(0, 0), new Point(3, -4), 5),
                Arguments.of(new Point(-3, 8), new Point(6, 2), Math.sqrt(117)),
                Arguments.of(new Point(0, 0), new Point(1, 1), Math.sqrt(2)),
                Arguments.of(new Point(-2, -2), new Point(1, 1), Math.sqrt(18))
        );
    }


    static Stream<Arguments> middleTestCases() {
        return Stream.of(
                Arguments.of(new Point(0.5, 0.5), new Segment(new Point(0, 0), new Point(1, 1))),
                Arguments.of(new Point(-1.5, 0.5), new Segment(new Point(-1, -1), new Point(-2, 2))),
                Arguments.of(new Point(4.5, 1.5), new Segment(new Point(0, 3), new Point(9, 0))),
                Arguments.of(new Point(1, 1), new Segment(new Point(0, 2), new Point(2, 0))),
                Arguments.of(new Point(2, 1.5), new Segment(new Point(0, 3), new Point(4, 0))),
                Arguments.of(new Point(0, -1), new Segment(new Point(-1, -3), new Point(1, 1))),
                Arguments.of(new Point(0, 2), new Segment(new Point(0, 1), new Point(0, 3)))
        );
    }

    static Stream<Arguments> intersectionTestCases() {
        return Stream.of(
                Arguments.of(
                        new Segment(new Point(0, 3), new Point(9, 0)),
                        new Segment(new Point(0, 2), new Point(10, 0)),
                        new Point(7.5, 0.5)
                ),
                Arguments.of(
                        new Segment(new Point(0, 0), new Point(3, 4)),
                        new Segment(new Point(0, 0), new Point(5, 100)),
                        new Point(0, 0)
                ),
                Arguments.of(
                        new Segment(new Point(2, 5), new Point(5, 1)),
                        new Segment(new Point(0, 2), new Point(5, 5)),
                        new Point(2.9310344827586206, 3.7586206896551726)
                ),
                Arguments.of(
                        new Segment(new Point(2, 5), new Point(0.5, 1.5)),
                        new Segment(new Point(0, 2), new Point(5, 5)),
                        new Point(0.9615384615384616, 2.576923076923077)
                ),
                Arguments.of(
                        new Segment(new Point(2, 5), new Point(0.5, 1.5)),
                        new Segment(new Point(0, 2), new Point(2, 5)),
                        new Point(2, 5)
                ),
                Arguments.of(
                        new Segment(new Point(-3, 0.5), new Point(0.5, 1.5)),
                        new Segment(new Point(0, 2), new Point(-3, -1.5)),
                        new Point(-0.7297297297297297, 1.1486486486486487)
                ),
                Arguments.of(
                        new Segment(new Point(0, 0), new Point(1, 1)),
                        new Segment(new Point(1, 1), new Point(2, 2)),
                        null
                ),
                Arguments.of(
                        new Segment(new Point(0, 0), new Point(1, 1)),
                        new Segment(new Point(2, 2), new Point(3, 3)),
                        null
                ),
                Arguments.of(
                        new Segment(new Point(0, 0), new Point(2, 2)),
                        new Segment(new Point(2, 2), new Point(1, 1)),
                        null
                ),
                Arguments.of(
                        new Segment(new Point(0, 0), new Point(1, 1)),
                        new Segment(new Point(-1, -1), new Point(-2, 2)),
                        null
                ),
                Arguments.of(
                        new Segment(new Point(0, 3), new Point(9, 0)),
                        new Segment(new Point(0, 2), new Point(2, 0)),
                        null
                ),
                Arguments.of(
                        new Segment(new Point(0, 3), new Point(4, 0)),
                        new Segment(new Point(-1, -3), new Point(1, 1)),
                        null
                )
        );
    }

    private String segmentCaseToString(Point start, Point end) {
        return new StringJoiner("->", "[", "]")
                .add(pointToString(start))
                .add(pointToString(end))
                .toString();
    }

    private String pointToString(final Point point) {
        if (point == null) {
            return null;
        }
        return new StringJoiner(";", "(", ")")
                .add(Double.toString(point.x()))
                .add(Double.toString(point.y()))
                .toString();
    }
}