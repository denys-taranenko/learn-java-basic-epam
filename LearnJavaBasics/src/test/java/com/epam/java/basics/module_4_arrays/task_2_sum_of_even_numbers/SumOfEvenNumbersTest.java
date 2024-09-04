package com.epam.java.basics.module_4_arrays.task_2_sum_of_even_numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfEvenNumbersTest {

    @ParameterizedTest(name = "[{index}] [{0}]")
    @MethodSource("testCases")
    public void sumTest(int expected, int[] array) {
        assertEquals(expected, SumOfEvenNumbers.sum(array));
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(10, new int[]{1, 3, 2, 8, 15, 199}),
                arguments(208, new int[]{1, 3, 2, 8, 198, 15}),
                arguments(0, IntStream.generate(() -> 1).limit(1000).toArray()),
                arguments(2000, IntStream.generate(() -> 2).limit(1000).toArray()),
                arguments(0, IntStream.generate(() -> 0).limit(1000).toArray()),
                arguments(250500, IntStream.iterate(1, i -> i + 1).limit(1000).toArray()),
                arguments(4840, IntStream.iterate(1, i -> i + 3).limit(80).toArray()),
                arguments(1048574, IntStream.iterate(1, i -> i + i).limit(20).toArray()),
                arguments(0, IntStream.iterate(1, i -> -i).limit(80).toArray()),
                arguments(-1560, IntStream.iterate(1, i -> i - 1).limit(80).toArray()),
                arguments(50, IntStream.iterate(50, i -> i - 1).limit(100).toArray()),
                arguments(-4900, IntStream.iterate(50, i -> i - 2).limit(100).toArray()),
                arguments(-4850, IntStream.iterate(50, i -> i - 3).limit(100).toArray())
        );
    }


    @Test
    public void nullOrEmptyTest() {
        int[] emptyArray = new int[0];

        assertEquals(0, SumOfEvenNumbers.sum(null));
        assertEquals(0, SumOfEvenNumbers.sum(emptyArray));
    }
}