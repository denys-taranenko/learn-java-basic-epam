package com.epam.java.basics.module_14_wrapper_classes.task_1_battleship8x8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Battleship8x8Test {

    @ParameterizedTest
    @MethodSource({"regularCases"})
    void testRegularCases(long ships, List<String> shots, String expectedStateResults, List<Boolean> expectedShotResults) {
        Battleship8x8 battle = new Battleship8x8(ships);
        final List<Boolean> shotResults = shots.stream()
                .map(battle::shoot)
                .collect(Collectors.toList());
        assertEquals(expectedStateResults, battle.state().strip());
        assertEquals(expectedShotResults, shotResults);
    }

    public static Stream<Arguments> regularCases() {
        return Stream.of(
                arguments(
                        0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L,
                        List.of("A1", "B1", "C1", "D1"),
                        """
                                ☒☒☒☒....
                                .....☐☐☐
                                ........
                                ..☐☐....
                                ......☐.
                                .☐......
                                ........
                                ........""",
                        List.of(true, true, true, true)
                ),
                arguments(
                        0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L,
                        List.of("A1", "A2", "A3", "A4"),
                        """
                                ☒☐☐☐....
                                ×....☐☐☐
                                ×.......
                                ×.☐☐....
                                ......☐.
                                .☐......
                                ........
                                ........""",
                        List.of(true, false, false, false)
                ),
                arguments(
                        0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L,
                        List.of("C4", "D4", "E4", "F4"),
                        """
                                ☐☐☐☐....
                                .....☐☐☐
                                ........
                                ..☒☒××..
                                ......☐.
                                .☐......
                                ........
                                ........""",
                        List.of(true, true, false, false)
                ),
                arguments(
                        0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L,
                        List.of("A1", "B2", "C3", "D4", "E5", "F6", "G7"),
                        """
                                ☒☐☐☐....
                                .×...☐☐☐
                                ..×.....
                                ..☐☒....
                                ....×.☐.
                                .☐...×..
                                ......×.
                                ........""",
                        List.of(true, false, false, true, false, false, false)
                ),
                arguments(
                        0b01000000_01000000_01000000_01000000_00001110_00000001_00000100_00000000L,
                        List.of("A1", "B7", "A5", "H4", "H1", "D3"),
                        """
                                ×☐.....×
                                .☐......
                                .☐.×....
                                .☐.....×
                                ×...☐☐☐.
                                .......☐
                                .×...☐..
                                ........""",
                        List.of(false, false, false, false, false, false)
                ),
                arguments(
                        0b01010000_01000010_01000100_01000000_00001110_00110001_10000100_11100000L,
                        List.of("A3", "D7", "A5", "F3", "H8", "D3", "B3", "G8", "C3"),
                        """
                                .☐.☐....
                                .☐....☐.
                                ×☒××.☒..
                                .☐......
                                ×...☐☐☐.
                                ..☐☐...☐
                                ☐..×.☐..
                                ☐☐☐...××""",
                        List.of(false, false, false, true, false, false, true, false, false)
                ));
    }
}