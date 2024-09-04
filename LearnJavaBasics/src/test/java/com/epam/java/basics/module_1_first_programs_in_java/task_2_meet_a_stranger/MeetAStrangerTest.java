package com.epam.java.basics.module_1_first_programs_in_java.task_2_meet_a_stranger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

class MeetAStrangerTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void correctOutput(String expected, String userInput) {
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        PrintStream defaultOut = System.out;
        InputStream defaultIn = System.in;

        try {
            MeetAStranger.main(new String[]{});
            printStream.flush();
            String actual = out.toString().trim();
            assertEquals(expected, actual);
        }
        finally {
            System.setIn(defaultIn);
            System.setOut(defaultOut);
        }
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Hello, Stranger", "Stranger"),
                Arguments.of("Hello, Mister Stranger", "Mister Stranger"),
                Arguments.of("Hello, Robert Downey Jr", "Robert Downey Jr")
        );
    }
}