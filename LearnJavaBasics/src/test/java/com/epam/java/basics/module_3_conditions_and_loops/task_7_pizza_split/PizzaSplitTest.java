package com.epam.java.basics.module_3_conditions_and_loops.task_7_pizza_split;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaSplitTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(String expected, String userInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        PrintStream defaultOut = System.out;
        InputStream defaultIn = System.in;

        try {
            PizzaSplit.main(null);
            String outputStr = byteArrayOutputStream.toString().trim();
            String[] words = outputStr.split(" ");
            String actual = words[words.length-1].trim();
            assertEquals(expected, actual);
        } finally {
            System.setIn(defaultIn);
            System.setOut(defaultOut);
        }
    }

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("3", "3 8"),
                Arguments.of("1", "2 8"),
                Arguments.of("1", "1 8"),
                Arguments.of("5", "5 8"),
                Arguments.of("7", "7 8"),
                Arguments.of("3", "3 5"),
                Arguments.of("2", "2 7"),
                Arguments.of("10", "10 1"),
                Arguments.of("1", "3 9"),
                Arguments.of("2", "4 6")
        );
    }
}