package com.epam.java.basics.module_3_conditions_and_loops.task_5_max_value_in_sequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class FindMaxInSeqTest {
    private final InputStream inputStream = System.in;

    @Test
    public void testSeq11() throws IOException {
        String input = "1 2 3 7 12 1 4 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(12, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testSeq12() throws IOException {
        String input = "3 4 9 1 4 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(9, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testNegativeValues() throws IOException {
        String input = "-3 4 -9 1 -4 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(4, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testNegativeMaximum() throws IOException {
        String input = "-3 -4 -9 -1 -4 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(-1, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testNegativeDuplicatedMaximum() throws IOException {
        String input = "-3 -4 -9 -4 -1 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(-1, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testDuplicatedMaximum() throws IOException {
        String input = "9 -3 9 4 9 -1 4 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(9, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testPolydigitNumbers() throws IOException {
        String input = "99 -321 9 431 99 -11 4 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(431, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void oneNumberSequence1() throws IOException {
        String input = "34567 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(34567, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void oneNumberSequence2() throws IOException {
        String input = "-934567 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(-934567, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }

    @Test
    public void testHavingIntegerMaxValue() throws IOException {
        String input = "-934567 4567 2147483647 -1 6273 -56789 3 2346 -18384 -483642347 6 0";
        try( InputStream in = new ByteArrayInputStream(input.getBytes()) ) {
            System.setIn(in);
            Assertions.assertEquals(2147483647, FindMaxInSeq.max());
        } finally {
            System.setIn(inputStream);
        }
    }
}