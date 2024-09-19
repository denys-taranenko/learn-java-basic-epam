package com.epam.java.basics.module_18_sets.task_1_ranged_ops_integer_set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RangedOpsIntegerSetRandomTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                42,
                654692,
                7714,
                845632,
                15966,
                12358,
                852139,
                8569,
                112584,
                3263
        ).map(i -> arguments(i, expectedList(i)));
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("testCases")
    void testInitialState(int seed, List<String> expected) {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        Random random = new Random(seed);

        addRandomRange(set, random);
        assertEquals(expected.get(0), setToString(set));

        removeRandomRange(set, random);
        assertEquals(expected.get(1), setToString(set));

        addRandomRange(set, random);
        assertEquals(expected.get(2), setToString(set));

        removeRandomRange(set, random);
        assertEquals(expected.get(3), setToString(set));
    }

    private void removeRandomRange(final RangedOpsIntegerSet set, final Random random) {
        set.remove(-random.nextInt(100), random.nextInt(100));
    }

    private void addRandomRange(final RangedOpsIntegerSet set, final Random random) {
        set.add(-random.nextInt(100), random.nextInt(100));
    }

    private String setToString(final RangedOpsIntegerSet set) {
        return set.stream()
                .map(i -> Integer.toString(i))
                .collect(Collectors.joining(" "));
    }

    private void writeFile(final int seed, final String actual) {
        try {
            Files.writeString(
                    Path.of("src", "test", "resources", "sets", seed + ".txt"),
                    actual + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> expectedList(int seed) {
        try {
            return Files.readAllLines(Path.of("src", "test", "resources", "sets", seed + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
