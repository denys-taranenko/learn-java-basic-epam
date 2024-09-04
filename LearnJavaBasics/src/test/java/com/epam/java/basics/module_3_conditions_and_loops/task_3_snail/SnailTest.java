package com.epam.java.basics.module_3_conditions_and_loops.task_3_snail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SnailTest {

    @ParameterizedTest
    @MethodSource("data")
    public void test(String expected, String a, String b, String top) {
        final String nums = a + System.lineSeparator() + b + System.lineSeparator() + top + System.lineSeparator();

        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;
        System.setOut(controlledOut);

        final ByteArrayInputStream byteIn = new ByteArrayInputStream(nums.getBytes());
        BufferedInputStream controlledIn = new BufferedInputStream(byteIn);
        InputStream defaultIn = System.in;
        System.setIn(controlledIn);

        try {
            Snail.main(new String[]{});
            controlledOut.flush();
            final String actual = sink.toString().trim();
            String[] temp = actual.split(System.lineSeparator());
            assertEquals(expected,temp[temp.length - 1]);
        } finally {
            System.setOut(defaultOut);
            System.setIn(defaultIn);
        }
    }

    static Stream<Arguments> data() {
        return Stream.of(
                arguments("8", "3", "2", "10"),
                arguments("6", "4", "2", "14"),
                arguments("7", "4", "3", "10"),
                arguments("Impossible", "4", "4", "10"),
                arguments("Impossible", "5", "6", "10"),
                arguments("1", "5", "7", "2"),
                arguments("1", "5", "5", "3"),
                arguments("10", "2", "1", "11"),
                arguments("1", "12", "0", "10"),
                arguments("1", "12", "100", "10"),
                arguments("1", "123", "256", "12"),
                arguments("1", "123", "256", "123"),
                arguments("4", "4", "1", "13")
        );
    }
}