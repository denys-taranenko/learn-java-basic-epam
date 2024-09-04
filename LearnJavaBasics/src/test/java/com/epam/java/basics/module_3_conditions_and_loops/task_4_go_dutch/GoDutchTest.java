package com.epam.java.basics.module_3_conditions_and_loops.task_4_go_dutch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GoDutchTest {

    @ParameterizedTest
    @MethodSource("correctDataProvider")
    void correctInputTest(String totalBill, String numberOfFriends, String partToPay) {
        String input = totalBill + System.lineSeparator() + numberOfFriends;

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedInputStream controlledIn = new BufferedInputStream(inputStream);
        InputStream defaultIn = System.in;
        System.setIn(controlledIn);

        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;
        System.setOut(controlledOut);

        try {
            GoDutch.main(new String[]{});
            controlledOut.flush();
            final String actual = sink.toString().trim();
            assertEquals(partToPay, actual);
        } finally {
            System.setIn(defaultIn);
            System.setOut(defaultOut);
        }
    }

    @ParameterizedTest
    @MethodSource("incorrectTotalBillDataProvider")
    void incorrectTotalBillTest(String totalBill, String numberOfFriends) {
        String input = totalBill + System.lineSeparator() + numberOfFriends;

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedInputStream controlledIn = new BufferedInputStream(inputStream);
        InputStream defaultIn = System.in;
        System.setIn(controlledIn);

        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;
        System.setOut(controlledOut);

        try {
            GoDutch.main(new String[]{});
            controlledOut.flush();
            final String actual = sink.toString().trim();
            assertEquals("Bill total amount cannot be negative", actual);
        } finally {
            System.setIn(defaultIn);
            System.setOut(defaultOut);
        }
    }

    @ParameterizedTest
    @MethodSource("incorrectNumberOfFriendsDataProvider")
    void incorrectNumberOfFriendsTest(String totalBill, String numberOfFriends) {
        String input = totalBill + System.lineSeparator() + numberOfFriends;

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        BufferedInputStream controlledIn = new BufferedInputStream(inputStream);
        InputStream defaultIn = System.in;
        System.setIn(controlledIn);

        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;
        System.setOut(controlledOut);

        try {
            GoDutch.main(new String[]{});
            controlledOut.flush();
            final String actual = sink.toString().trim();
            assertEquals("Number of friends cannot be negative or zero", actual);
        } finally {
            System.setIn(defaultIn);
            System.setOut(defaultOut);
        }
    }

    static Stream<Arguments> correctDataProvider() {
        return Stream.of(
                arguments("10000", "5", "2200"),
                arguments("5000", "1", "5500"),
                arguments("200", "220", "1"),
                arguments("0", "100", "0"),
                arguments("1", "1", "1")
        );
    }

    static Stream<Arguments> incorrectTotalBillDataProvider() {
        return Stream.of(
                arguments("-100", "2"),
                arguments("-2", "2"),
                arguments("-1", "1")
        );
    }

    static Stream<Arguments> incorrectNumberOfFriendsDataProvider() {
        return Stream.of(
                arguments("100", "-2"),
                arguments("340", "-2300"),
                arguments("1236", "0")
        );
    }
}