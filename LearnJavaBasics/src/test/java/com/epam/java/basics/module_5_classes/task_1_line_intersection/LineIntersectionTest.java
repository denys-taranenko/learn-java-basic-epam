package com.epam.java.basics.module_5_classes.task_1_line_intersection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LineIntersectionTest {

    @ParameterizedTest
    @CsvSource({
            "1,2,2,1,(1;3)",
            "1,0,2,0,(0;0)",
            "4,3,1,3,(0;3)",
            "2,56,4,-4,(30;116)",
            "5,-8,3,2,(5;17)",
    })
    public void regularTest(int k1, int b1, int k2, int b2, String expected) {
        Line line = new Line(k1, b1);
        Line line2 = new Line(k2, b2);
        assertEquals(expected, line.intersection(line2).toString());
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,0", "1,1,1,1", "3,-9,3,-9"})
    public void coincidingTest(int k1, int b1, int k2, int b2) {
        Line lhs = new Line(k1, b1);
        Line rhs = new Line(k2, b2);
        assertNull(lhs.intersection(rhs));
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,-3", "1,-1,1,1", "3,359,3,-9"})
    public void parallelTest(int k1, int b1, int k2, int b2) {
        Line lhs = new Line(k1, b1);
        Line rhs = new Line(k2, b2);
        assertNull(lhs.intersection(rhs));
    }
}