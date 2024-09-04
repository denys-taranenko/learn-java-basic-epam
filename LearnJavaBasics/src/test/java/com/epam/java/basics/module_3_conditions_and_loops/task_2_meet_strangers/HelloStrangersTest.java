package com.epam.java.basics.module_3_conditions_and_loops.task_2_meet_strangers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HelloStrangersTest {

    private String runMain(String... lines) throws Exception {
        return tapSystemOutNormalized(() ->
                withTextFromSystemIn(lines)
                        .execute(() -> HelloStrangers.main(new String[]{})))
                .strip();
    }

    @Test
    @DisplayName("Test for zero input")
    void zeroInputTest() throws Exception {
        String actual = runMain("0");
        assertEquals("Oh, it looks like there is no one here", actual);
    }

    @Test
    @DisplayName("Test for negative input")
    void negInputTest() throws Exception {
        String actual = runMain("-1").strip();
        assertEquals("Seriously? Why so negative?", actual);
    }

    @ParameterizedTest
    @DisplayName("Test for regular and random cases")
    @MethodSource({"regularCases", "randomNames"})
    void anyNamesTest(List<String> namesList) throws Exception {

        String expected = namesList.stream()
                .map(name -> "Hello, " + name)
                .collect(Collectors.joining("\n"));

        String[] inputLines = Stream.concat(
                        Stream.of(Integer.toString(namesList.size())),
                        namesList.stream())
                .toArray(String[]::new);

        String actual = runMain(inputLines).strip();

        assertEquals(expected, actual);
    }

    static Stream<List<String>> regularCases() {
        return Stream.of(
                List.of("Angus"),
                List.of("Agent Smith"),
                List.of("Kiefer William Frederick Dempsey George Rufus Sutherland")
        );
    }

    static Stream<List<String>> randomNames() {
        String[] names = {
                "John", "Dave", "Martin",
                "Jimmy", "Robert", "Paul",
                "Darth Vader", "Bilbo Baggins",
                "Carl Johnson", "Wastelander",
                "Billy Harrington", "R2-D2",
                "C-3PO", "1+-Pro-100-Tascher-+1"
        };
        return Stream.of(
                filler(names),
                filler(names),
                filler(names),
                filler(names),
                filler(names)
        );
    }

    static ArrayList<String> filler(String[] names) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= (int) (Math.random() * 100) % 10; i++) {
            list.add(names[(int) (Math.random() * 100) % names.length]);
        }
        return list;
    }
}