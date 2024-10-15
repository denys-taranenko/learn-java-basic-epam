package com.epam.java.basics.module_26_stream_api.task_1_stream_api_basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class MovieQueriesTest {

    private static final String lineSeparator = System.lineSeparator();
    private static final List<String> EMPTY_LIST = List.of();
    private static final List<String> CORRECT_LIST_WITHOUT_RESULT = List.of("Stranger things");
    private static final List<String> CORRECT_LIST_WITH_RESULT = List.of("Terminator", "Blade Runner", "Star Wars", "Indiana Jones", "Friends",
            "The Magnificent Seven", "The Dark Knight", "The Lord of the Rings: The Return of the King",
            "Pulp Fiction");


    @DisplayName("Count the movies in the list")
    @ParameterizedTest
    @MethodSource("getNumberOfMoviesListProvider")
    public void getNumberOfMoviesTest(List<String> movies, long expectedValue) {
        MovieQueries underTest = new MovieQueries(movies);
        long actual = underTest.getNumberOfMovies();
        assertEquals(expectedValue, actual,
                () -> "Wrong result in counting elements." + lineSeparator +
                        "Provided test data: " + movies + lineSeparator);
    }

    static Stream<Arguments> getNumberOfMoviesListProvider() {
        return Stream.of(
                Arguments.of(EMPTY_LIST, 0),
                Arguments.of(CORRECT_LIST_WITH_RESULT, 9)
        );
    }

    @DisplayName("Movie title starts with")
    @ParameterizedTest
    @MethodSource("getNumberOfMoviesThatStartsWithListProvider")
    public void getNumberOfMoviesThatStartsWithTest(List<String> movies, long expectedValue) {
        MovieQueries underTest = new MovieQueries(movies);
        String givenParameter = "The";
        long actual = underTest.getNumberOfMoviesThatStartsWith(givenParameter);
        assertEquals(expectedValue, actual, () -> "Wrong result in counting movies what starts with the given word: \"" +
                givenParameter + "\"" + lineSeparator +
                "Provided test data: " + movies + lineSeparator);
    }

    static Stream<Arguments> getNumberOfMoviesThatStartsWithListProvider() {
        return Stream.of(
                Arguments.of(EMPTY_LIST, 0),
                Arguments.of(CORRECT_LIST_WITH_RESULT, 3),
                Arguments.of(CORRECT_LIST_WITHOUT_RESULT, 0)
        );
    }

    @DisplayName("Movie title starts with and end with")
    @ParameterizedTest
    @MethodSource("getNumberOfMoviesThatStartsWithAndEndsWithListProvider")
    public void getNumberOfMoviesThatStartsWithAndEndsWithTest(List<String> movies, long expectedValue) {
        MovieQueries underTest = new MovieQueries(movies);
        String startsWith = "The";
        String endsWith = "g";
        long actual = underTest.getNumberOfMoviesThatStartsWithAndEndsWith(startsWith, endsWith);
        assertEquals(expectedValue, actual, () -> "Wrong result in counting movies what starts with: \"" +
                startsWith + "\" and end with \"" + endsWith + "\"" +  lineSeparator +
                "Provided test data: " + movies + lineSeparator);
    }

    static Stream<Arguments> getNumberOfMoviesThatStartsWithAndEndsWithListProvider() {
        return Stream.of(
                Arguments.of(EMPTY_LIST, 0),
                Arguments.of(CORRECT_LIST_WITH_RESULT, 1),
                Arguments.of(CORRECT_LIST_WITHOUT_RESULT, 0)
        );
    }

    @DisplayName("Length of the movie titles")
    @ParameterizedTest
    @MethodSource("getLengthOfTitleOfMoviesListProvider")
    public void getLengthOfTitleOfMoviesTest(List<String> movies, List<Integer> expectedValue) {
        MovieQueries underTest = new MovieQueries(movies);
        List<Integer> actual = underTest.getLengthOfTitleOfMovies();
        assertIterableEquals(expectedValue, actual, () -> "Wrong counting length of a title." + lineSeparator +
                "Provided test data: " + movies + lineSeparator);
    }

    static Stream<Arguments> getLengthOfTitleOfMoviesListProvider() {
        return Stream.of(
                Arguments.of(EMPTY_LIST, List.of()),
                Arguments.of(CORRECT_LIST_WITH_RESULT, List.of(10, 12, 9, 13, 7, 21, 15, 45, 12)),
                Arguments.of(CORRECT_LIST_WITHOUT_RESULT, List.of(15))
        );
    }

}
