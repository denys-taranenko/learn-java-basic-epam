package com.epam.java.basics.module_3_conditions_and_loops.task_8_quadratic_equation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    private ByteArrayOutputStream sink;
    private PrintStream controlledOut;
    private PrintStream defaultOut;
    private InputStream defaultIn;

    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);


    @ParameterizedTest
    @MethodSource("testCasesSingleRoot")
    void testSingleRoot(final String input, final String expected) {
        setControlledStreamsWithInput(input);
        try {
            QuadraticEquation.main(new String[]{});
            controlledOut.flush();
            double expectedRoot = parseNumber(expected);
            double actualRoot = parseNumber(getActualOutput());
            assertEquals(expectedRoot, actualRoot, 0.00001, "Error on input " + input);
        } finally {
            setStandardStreams();
        }
    }


    @ParameterizedTest
    @MethodSource("testCases2Roots")
    void test2Roots(final String input, final String expected) {
        setControlledStreamsWithInput(input);
        try {
            QuadraticEquation.main(new String[]{});
            controlledOut.flush();

            double[] expectedRoots = parseRoots(expected);
            double[] actualRoots = parseRoots(getActualOutput());

            assertArrayEquals(expectedRoots, actualRoots, 0.00001, "Error on input " + input);
        } finally {
            setStandardStreams();
        }
    }

    @ParameterizedTest
    @MethodSource("testCasesNoRoots")
    void testNoRoots(final String input) {
        setControlledStreamsWithInput(input);
        try {
            QuadraticEquation.main(new String[]{});
            controlledOut.flush();
            assertEquals("no roots", getActualOutput(), "Error on input " + input);
        } finally {
            setStandardStreams();
        }
    }

    static Stream<Arguments> testCasesSingleRoot() {
        return Stream.of(
                Arguments.of("1 -2 1", "1.0"),
                Arguments.of("1 0 0", "0.0"),
                Arguments.of("8 0 0", "0.0"),
                Arguments.of("1 -6 9", "3.0"),
                Arguments.of("1 12 36", "-6.0")
        );
    }

    static Stream<Arguments> testCases2Roots() {
        return Stream.of(
                Arguments.of("2 5 -3", "-3.0 0.5"),
                Arguments.of("1 -3 1", "0.3819660112501051 2.618033988749895"),
                Arguments.of("2 -38 156", "6.0 13.0"),
                Arguments.of("-0.5 34 1046.5", "-23.0 91.0")
        );
    }

    static Stream<Arguments> testCasesNoRoots() {
        return Stream.of(
                Arguments.of("-563 0 -5"),
                Arguments.of("2 10 30"),
                Arguments.of("-0.5 1 -50"),
                Arguments.of("1 11 111"),
                Arguments.of("2 2 2")
        );
    }

    private double[] parseRoots(final String input) {
        String[] inputTokens = input.split(" ");
        double[] roots = {parseNumber(inputTokens[0]), parseNumber(inputTokens[1])};
        if (roots[0] > roots[1]) {
            roots = new double[]{roots[1], roots[0]};
        }
        return roots;
    }

    private void setControlledStreamsWithInput(final String input) {

        sink = new ByteArrayOutputStream();
        controlledOut = new PrintStream(sink);
        String escapedInput = Arrays.stream(input.split(" "))
                .mapToDouble(this::parseNumber)
                .mapToObj(Double::toString)
                .collect(Collectors.joining(" "));
        ByteArrayInputStream controlledIn = new ByteArrayInputStream(escapedInput.getBytes());

        defaultOut = System.out;
        defaultIn = System.in;

        System.setOut(controlledOut);
        System.setIn(controlledIn);
    }

    private void setStandardStreams() {
        System.setOut(defaultOut);
        System.setIn(defaultIn);
    }


    private double parseNumber(final String string) {
        try {
            return numberFormat.parse(string).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String getActualOutput() {
        return sink.toString().replace(",", ".").trim();
    }
}