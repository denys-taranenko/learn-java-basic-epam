package com.epam.java.basics.module_6_introduction_to_oop.task_1_halving_carousel;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.CarouselRun;
import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.DecrementingCarousel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecrementingCarouselRunRandomTest {

    private static final String variant = "decrementing";

    @ParameterizedTest(name = "[1] {0} {1}")
    @MethodSource({"fullCases", "halfEmptyCases", "overflowCases"})
    void testCarouselRunWhileNotFinished(String collection, int seed) {
        Random random = new Random(seed);

        DecrementingCarousel carousel = generateCarousel(random, collection);
        CarouselRun run = carousel.run();

        List<Integer> runResult = new ArrayList<>();

        while (!run.isFinished()) {
            runResult.add(run.next());
        }

        List<Boolean> isFinishedResult = new ArrayList<>();
        for (int i = 0; i < runResult.size(); i++) {
            isFinishedResult.add(false);
        }
        isFinishedResult.add(true);

        assertEquals(getExpectedRunResult(collection, seed), runResult);
        assertEquals(getExpectedIsFinishedResult(collection, seed), isFinishedResult);
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @MethodSource({"fullCases", "halfEmptyCases", "overflowCases"})
    void testCarouselRunWhileNotNegative(String collection, int seed) {
        Random random = new Random(seed);

        DecrementingCarousel carousel = generateCarousel(random, collection);
        CarouselRun run = carousel.run();

        List<Integer> runResult = new ArrayList<>();
        List<Boolean> isFinishedResult = new ArrayList<>();

        isFinishedResult.add(run.isFinished());
        int nextVal;
        while ((nextVal = run.next()) != -1) {
            runResult.add(nextVal);
            isFinishedResult.add(run.isFinished());
        }

        assertEquals(getExpectedRunResult(collection, seed), runResult);
        assertEquals(getExpectedIsFinishedResult(collection, seed), isFinishedResult);
    }

    public static Stream<Arguments> fullCases() {
        return IntStream.of(
                        1,
                        56,
                        133976,
                        8513884,
                        322368,
                        6854)
                .mapToObj(i -> arguments("full", i));
    }

    public static Stream<Arguments> halfEmptyCases() {
        return IntStream.of(
                        1,
                        56,
                        133976,
                        3678,
                        264807,
                        1238732)
                .mapToObj(i -> arguments("half", i));
    }

    public static Stream<Arguments> overflowCases() {
        return IntStream.of(
                        1,
                        56,
                        133976,
                        8526458,
                        9656836,
                        98512357)
                .mapToObj(i -> arguments("over", i));
    }

    private static DecrementingCarousel generateCarousel(final Random random, final String collection) {
        int elements = 10 + random.nextInt(10);
        DecrementingCarousel carousel = new DecrementingCarousel(elements);

        if (collection.equals("half")) {
            elements -= (random.nextInt(7) + 1);
        } else if (collection.equals("over")) {
            elements += (random.nextInt(7) + 1);
        }
        for (int i = 0; i < elements; i++) {
            carousel.addElement(1 + random.nextInt(10));
        }
        return carousel;
    }

    private List<Boolean> getExpectedIsFinishedResult(final String collection, final int seed) {
        int size = getExpectedRunResult(collection, seed).size();
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(false);
        }
        result.add(true);
        return result;
    }

    private List<Integer> getExpectedRunResult(final String collection, final int seed) {
        return readExpectedList(collection, seed);
    }

    private static List<Integer> readExpectedList(String collection, int seed) {
        try {
            return Pattern.compile("\\D+").splitAsStream(
                            Files.readString(
                                    Path.of("src", "test", "resources", variant, collection, seed + ".txt")))
                    .filter(token -> !token.isBlank())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}