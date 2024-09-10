package com.epam.java.basics.module_13_enums.task_1_compass;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.epam.java.basics.module_13_enums.task_1_compass.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DirectionTest {

    @ParameterizedTest
    @MethodSource
    void ofDegrees(Direction expected, int degrees) {
        assertEquals(expected, Direction.ofDegrees(degrees));
    }

    @ParameterizedTest
    @MethodSource
    void closestToDegrees(Direction expected, int degrees) {
        assertEquals(expected, Direction.closestToDegrees(degrees));
    }

    @ParameterizedTest
    @MethodSource
    void opposite(Direction expected, Direction source) {
        assertEquals(expected, source.opposite());
    }

    @ParameterizedTest
    @MethodSource
    void differenceDegreesTo(int expected, Direction source, Direction param) {
        assertEquals(expected, source.differenceDegreesTo(param));
    }

    public static Stream<Arguments> ofDegrees() {
        return Stream.of(
                arguments(N, 0),
                arguments(NE, 45),
                arguments(E, 90),
                arguments(SE, 135),
                arguments(S, 180),
                arguments(SW, 225),
                arguments(W, 270),
                arguments(NW, 315),

                arguments(N, 360),
                arguments(NE, 765),
                arguments(NW, -45),
                arguments(SW, -135),

                arguments(null, 44),
                arguments(null, 1111)
        );
    }

    public static Stream<Arguments> closestToDegrees() {
        return Stream.of(
                arguments(N, 0),
                arguments(NE, 45),
                arguments(E, 90),
                arguments(SE, 135),
                arguments(S, 180),
                arguments(SW, 225),
                arguments(W, 270),
                arguments(NW, 315),

                arguments(N, 360),
                arguments(NE, 765),
                arguments(NW, -45),
                arguments(SW, -135),

                arguments(NE, 44),
                arguments(S, 200),
                arguments(SW, 205),
                arguments(NE, 1111)
        );
    }

    public static Stream<Arguments> opposite() {
        return Stream.of(
                arguments(N, S),
                arguments(NE, SW),
                arguments(E, W),
                arguments(SE, NW),
                arguments(S, N),
                arguments(SW, NE),
                arguments(W, E),
                arguments(NW, SE)
        );
    }

    public static Stream<Arguments> differenceDegreesTo() {
        return Stream.of(
                arguments(180, N, S),
                arguments(180, NE, SW),
                arguments(180, E, W),
                arguments(180, SE, NW),
                arguments(180, S, N),
                arguments(180, SW, NE),
                arguments(180, W, E),
                arguments(180, NW, SE),

                arguments(45, N, NW),
                arguments(45, N, NE),
                arguments(45, NE, N),

                arguments(45, S, SE),
                arguments(45, SE, E),
                arguments(45, E, SE),

                arguments(135, S, NE),
                arguments(135, SE, N),
                arguments(135, SE, W),

                arguments(90, S, E),
                arguments(90, N, E),
                arguments(90, NW, SW)
        );
    }
}