package com.epam.java.basics.module_9_working_with_strings.task_1_words;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    static final String[] separators = new String[]{", ", " ", ",", ":", ": ", "; ", ";",
            ".", ". ", "!", "! "};

    @Test
    void testCountReturnsZeroForNullWords() {
        String sample = "sample";
        assertEquals(0, StringUtil.countEqualIgnoreCaseAndSpaces(null, sample));
    }

    @Test
    void testCountReturnsZeroForEmptyWords() {
        String[] words = new String[0];
        String sample = "sample";
        assertEquals(0, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
    }

    @Test
    void testCountReturnsZeroForNullSample() {
        String[] words = new String[]{"word", "   words", "WoRdSS"};
        String[] copy = Arrays.copyOf(words, words.length);
        assertEquals(0, StringUtil.countEqualIgnoreCaseAndSpaces(words, null));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsZeroForEmptySample() {
        String[] words = new String[]{"word", "   words", "WoRdSS"};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "";
        assertEquals(0, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsForSample() {
        String[] words = new String[]{"   nice ", "nICE", "nic3"};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "NICE";
        assertEquals(2, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsForSample2() {
        String[] words = new String[]{" game", "  game", "          game     \t "};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "game";
        assertEquals(3, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsForSample3() {
        String[] words = new String[]{"take", "TAKE", "taKE", "ekat", "TakE", "TAKe", "ttt", "taaaake"};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "\ttake\t";
        assertEquals(5, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsForSample4() {
        String[] words = new String[]{"empty", "", "\t", "     ", "EMPTY"};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "empty";
        assertEquals(2, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsForNumbers() {
        String[] words = new String[]{"  123", "      123", "123\t", "\t\t\t123", "1234", "1230", "321"};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "123";
        assertEquals(4, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testCountReturnsForSeparatedParts() {
        String[] words = new String[]{"sch ool", "SCHOO L", "\tschool\t", "     schoo", "s c h o o l"};
        String[] copy = Arrays.copyOf(words, words.length);
        String sample = "scHooL";
        assertEquals(1, StringUtil.countEqualIgnoreCaseAndSpaces(words, sample));
        assertArrayEquals(copy, words);
    }

    @Test
    void testSplitReturnsNullForNullText() {
        assertNull(StringUtil.splitWords(null));
    }

    @Test
    void testSplitReturnsNullForEmptyText() {
        assertNull(StringUtil.splitWords(""));
    }

    @ParameterizedTest
    @MethodSource("makeStraightSeparatorsStrings")
    void testSplitReturnsNullForSeparatingCharsString(String sepStr) {
        assertNull(StringUtil.splitWords(sepStr));
    }

    static Stream<String> makeStraightSeparatorsStrings() {
        StringBuilder builder = new StringBuilder();
        Stream.Builder<String> argBuilder = Stream.builder();
        for (String sep : separators) {
            builder.append(sep);
            argBuilder.add(builder.toString());
        }

        argBuilder.add("  !!! ,, ;; ;; , !!! ....  ... .. . ...   ??  . ....   ");
        argBuilder.add("       ");
        argBuilder.add("...............");
        argBuilder.add("?!?!!!!?...!....!      ");
        argBuilder.add(" ! ! ! ? ? ");

        return argBuilder.build();
    }

    @Test
    void testSplitReturnsForSingleWord() {
        String text = "text";
        String[] expected = new String[]{text};
        String[] result = StringUtil.splitWords(text);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSplitReturnsForTextStartingWithSeparators() {
        String text = " !!!..  first, second: third";
        String[] expected = new String[]{"first", "second", "third"};
        String[] result = StringUtil.splitWords(text);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSplitReturnsForTextEndingWithSeparators() {
        String text = "first...second!!!!third      ::: ;; ";
        String[] expected = new String[]{"first", "second", "third"};
        String[] result = StringUtil.splitWords(text);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSplitReturnsForUpperCaseText() {
        String text = " YELL STOP WORD;RAKE... WELL: HINT; STAY! ALIVE.";
        String[] expected = new String[]{"YELL", "STOP", "WORD", "RAKE", "WELL", "HINT", "STAY", "ALIVE"};
        String[] result = StringUtil.splitWords(text);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSplitReturnsForNumbers() {
        String text = "123...495;;024, 77, 1231, 55";
        String[] expected = new String[]{"123", "495", "024", "77", "1231", "55"};
        String[] result = StringUtil.splitWords(text);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSplitReturnsForSample() {
        String text = " ;:a ,,,  b ::; c,d:e    f:g::;;;::::    h            ";
        String[] expected = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] result = StringUtil.splitWords(text);
        assertArrayEquals(expected, result);
    }

    @Test
    void testConvertReturnsNullForNullPath() {
        assertNull(StringUtil.convertPath(null, false));
        assertNull(StringUtil.convertPath(null, true));
    }

    @Test
    void testConvertReturnsNullForEmptyPath() {
        String path = "";
        assertNull(StringUtil.convertPath(path, false));
        assertNull(StringUtil.convertPath(path, true));
    }

    @ParameterizedTest
    @MethodSource("makeIllegalPaths")
    void testConvertReturnsNullForIllegalPath(String path) {
        assertNull(StringUtil.convertPath(path, false));
        assertNull(StringUtil.convertPath(path, true));
    }

    static Stream<String> makeIllegalPaths() {
        String[] paths = new String[]{
                "/folder1/folder2\\folder3",
                "C:\\User/root",
                "/dev/~/",
                "C:/a/b/c///d",
                "~\\folder",
                "~/~",
                "~~",
                "C:\\Folder\\Subfolder\\C:\\",
        };

        return Stream.of(paths);
    }

    @Test
    void testConvertReturnsForSample() {
        String unixPath = "/root/logs";
        String winPath = "C:\\root\\logs";
        assertEquals(winPath, StringUtil.convertPath(unixPath, true));
        assertEquals(unixPath, StringUtil.convertPath(unixPath, false));
    }

    @Test
    void testConvertReturnsForSample2() {
        String path = "file.txt";
        assertEquals(path, StringUtil.convertPath(path, true));
        assertEquals(path, StringUtil.convertPath(path, false));
    }

    @Test
    void testConvertReturnsForSample3() {
        String unixPath = "/root/logs/end.log";
        String winPath = "C:\\root\\logs\\end.log";
        assertEquals(winPath, StringUtil.convertPath(unixPath, true));
    }

    @ParameterizedTest
    @MethodSource("makeUnixWinPairs")
    void testConvertReturnsForUnixToWin(String unixPath, String winPath) {
        assertEquals(winPath, StringUtil.convertPath(unixPath, true));
        assertEquals(unixPath, StringUtil.convertPath(unixPath, false));
    }

    @ParameterizedTest
    @MethodSource("makeUnixWinPairs")
    void testConvertReturnsForWinToUnix(String unixPath, String winPath) {
        assertEquals(unixPath, StringUtil.convertPath(winPath, false));
        assertEquals(winPath, StringUtil.convertPath(winPath, true));
    }

    @ParameterizedTest
    @MethodSource("makeUnixWinPairs")
    void testConvertReturnsForWinToUnixToWin(String unixPath, String winPath) {
        String winResult = StringUtil.convertPath(unixPath, true);
        assertEquals(winPath, winResult);
        String unixResult = StringUtil.convertPath(winPath, false);
        assertEquals(unixPath, unixResult);
        winResult = StringUtil.convertPath(unixResult, true);
        assertEquals(winPath, winResult);
    }

    @ParameterizedTest
    @MethodSource("makeUnixWinPairs")
    void testConvertReturnsForUnixToWinToUnix(String unixPath, String winPath) {
        String unixResult = StringUtil.convertPath(winPath, false);
        assertEquals(unixPath, unixResult);
        String winResult = StringUtil.convertPath(unixResult, true);
        assertEquals(winPath, winResult);
        unixResult = StringUtil.convertPath(winResult, false);
        assertEquals(unixPath, unixResult);
    }

    static Stream<Arguments> makeUnixWinPairs() {
        Stream.Builder<Arguments> builder = Stream.builder();
        builder.add(Arguments.arguments("~/secret/dont_look.txt", "C:\\User\\secret\\dont_look.txt"));
        builder.add(Arguments.arguments(".", "."));
        builder.add(Arguments.arguments("~", "C:\\User"));
        builder.add(Arguments.arguments("~/", "C:\\User\\"));
        builder.add(Arguments.arguments("..", ".."));
        builder.add(Arguments.arguments("/", "C:\\"));
        builder.add(Arguments.arguments("../anoTHER_folder", "..\\anoTHER_folder"));
        builder.add(Arguments.arguments("../anoTHER_folder/", "..\\anoTHER_folder\\"));
        builder.add(Arguments.arguments("../folder name", "..\\folder name"));
        builder.add(Arguments.arguments("dir/subdir/wrongsubdir/../rightdir", "dir\\subdir\\wrongsubdir\\..\\rightdir"));
        builder.add(Arguments.arguments("/root/logs/end.log",  "C:\\root\\logs\\end.log"));
        return builder.build();
    }

    @Test
    void testJoinReturnsNullForNull() {
        assertNull(StringUtil.joinWords(null));
    }

    @Test
    void testJoinReturnsNullForEmpty() {
        String[] words = new String[0];
        assertNull(StringUtil.joinWords(words));
    }

    @Test
    void testJoinReturnNullForArrayOfEmptyStrings() {
        String[] words = new String[]{"", "", ""};
        String[] copy = Arrays.copyOf(words, words.length);
        assertNull(StringUtil.joinWords(words));
        assertArrayEquals(copy, words);
    }

    @Test
    void testJoinReturnsForSingleWord() {
        String[] words = new String[]{"testing"};
        String[] copy = Arrays.copyOf(words, words.length);
        String expected = "[testing]";
        assertEquals(expected, StringUtil.joinWords(words));
        assertArrayEquals(copy, words);
    }

    @Test
    void testJoinReturnsForTwoWords() {
        String[] words = new String[]{"first", "second"};
        String[] copy = Arrays.copyOf(words, words.length);
        String expected = "[first, second]";
        assertEquals(expected, StringUtil.joinWords(words));
        assertArrayEquals(copy, words);
    }

    @ParameterizedTest
    @MethodSource("makeWordsForJoining")
    void testJoinReturnsForSample(String[] words, String expected) {
        String[] copy = Arrays.copyOf(words, words.length);
        assertEquals(expected, StringUtil.joinWords(words));
        assertArrayEquals(copy, words);
    }

    static Stream<Arguments> makeWordsForJoining() {
        Stream.Builder<Arguments> builder = Stream.builder();
        builder.add(Arguments.arguments(new String[]{"go", "with", "the", "", "FLOW"}, "[go, with, the, FLOW]"));
        builder.add(Arguments.arguments(new String[]{"1", "", "", "2", "345", "10"}, "[1, 2, 345, 10]"));
        builder.add(Arguments.arguments(new String[]{"", "", "", " 2 ", "3 4 5", ""}, "[ 2 , 3 4 5]"));
        builder.add(Arguments.arguments(new String[]{"UPPERCASEWORD", "lowercaseword"}, "[UPPERCASEWORD, lowercaseword]"));
        builder.add(Arguments.arguments(new String[]{"[First, Second]", "", "[Third, Fourth]", "take"},
                "[[First, Second], [Third, Fourth], take]"));
        return builder.build();
    }
}