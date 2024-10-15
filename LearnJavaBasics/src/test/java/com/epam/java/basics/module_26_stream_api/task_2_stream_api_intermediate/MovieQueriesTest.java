package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate;

import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Genre;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Movie;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MovieQueriesTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @DisplayName("Instantiate MovieQueries with null list")
    @Test
    public void nullConstructTestThrowIllegalArgExp() {
        assertThrows(IllegalArgumentException.class, () -> new MovieQueries(null),
                "You have thrown wrong type of exception when list is null." + LINE_SEPARATOR);
    }

    @DisplayName("Check if all movies to belongs to the given genre")
    @ParameterizedTest
    @MethodSource("checkAllGenreListProvider")
    public void checkGenreOfAllMoviesTest(List<Movie> movies, boolean expected) {
        MovieQueries underTest = new MovieQueries(movies);
        Genre givenParameter = Genre.ACTION;
        boolean actual = underTest.checkGenreOfAllMovies(givenParameter);
        assertEquals(expected, actual, "Wrong result to check all movies belong to the given genre: \"" +
                givenParameter + "\"" + LINE_SEPARATOR +
                "Provided test data: " + movies + LINE_SEPARATOR);
    }

    static Stream<Arguments> checkAllGenreListProvider() {
        List<Movie> movies = createMovies();
        Movie testMovieRomance = createRomanceMovie();
        testMovieRomance.setGenres(List.of(Genre.ROMANCE));
        return Stream.of(
                Arguments.of(List.of(), true),
                Arguments.of(List.of(movies.get(0), movies.get(1)), true),
                Arguments.of(List.of(movies.get(2), testMovieRomance), false),
                Arguments.of(List.of(movies.get(2), movies.get(0)), false)
        );
    }

    @DisplayName("Find at least one movie that belongs to the given genre")
    @ParameterizedTest
    @MethodSource("checkAnyGenreListProvider")
    public void checkGenreOfAnyMoviesTest(List<Movie> movies, boolean expected) {
        MovieQueries underTest = new MovieQueries(movies);
        Genre givenParameter = Genre.ACTION;
        boolean actual = underTest.checkGenreOfAnyMovies(givenParameter);
        assertEquals(expected, actual, "Wrong result to find a movie belongs to the given genre: \"" +
                givenParameter + "\"" + LINE_SEPARATOR +
                "Provided test data: " + movies + LINE_SEPARATOR);
    }

    static Stream<Arguments> checkAnyGenreListProvider() {
        List<Movie> movies = createMovies();
        Movie testMovie4 = createRomanceMovie();
        return Stream.of(
                Arguments.of(List.of(), false),
                Arguments.of(List.of(movies.get(0), movies.get(1)), true),
                Arguments.of(List.of(movies.get(2), testMovie4), false),
                Arguments.of(List.of(movies.get(2), movies.get(0)), true)
        );
    }

    @DisplayName("Checks if there is at least one movie directed by the given director")
    @ParameterizedTest
    @MethodSource("checkDirectorListProvider")
    public void checkMovieIsDirectedByTest(List<Movie> movies, boolean expected) {
        MovieQueries underTest = new MovieQueries(movies);
        Person findPerson = createPersons().getFirst();
        boolean actual = underTest.checkMovieIsDirectedBy(findPerson);
        assertEquals(expected, actual, "Wrong result to check movie list contains at least one movie what directed by: \"" +
                findPerson + "\"" + LINE_SEPARATOR +
                "Provided test data: " + movies + LINE_SEPARATOR);
    }

    static Stream<Arguments> checkDirectorListProvider() {
        List<Movie> movies = createMovies();
        return Stream.of(
                Arguments.of(List.of(), false),
                Arguments.of(List.of(movies.get(0), movies.get(1)), true),
                Arguments.of(List.of(movies.get(1), movies.get(2)), true),
                Arguments.of(List.of(movies.get(2)), false)
        );
    }

    @DisplayName("Count total length of movies")
    @ParameterizedTest
    @MethodSource("calculateTotalLengthListProvider")
    public void calculateTotalLengthTest(List<Movie> movies, int expected) {
        MovieQueries underTest = new MovieQueries(movies);
        int actual = underTest.calculateTotalLength();
        assertEquals(expected, actual, "Wrong result in calculate all movie summed length." + LINE_SEPARATOR +
                "Provided test data: " + movies + LINE_SEPARATOR);
    }

    static Stream<Arguments> calculateTotalLengthListProvider() {
        List<Movie> movies = createMovies();
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(movies, 390)
        );
    }

    @DisplayName("Find movies longer than the given parameter")
    @ParameterizedTest
    @MethodSource("moviesLongerThanListProvider")
    public void moviesLongerThanLengthTest(List<Movie> movies, long expected) {
        MovieQueries underTest = new MovieQueries(movies);
        int minutes = 120;
        long actual = underTest.moviesLongerThan(minutes);
        assertEquals(expected, actual, "Wrong result to count movies longer than: " + minutes + " minutes." +
                LINE_SEPARATOR + "Provided test data: " + movies + LINE_SEPARATOR);
    }

    static Stream<Arguments> moviesLongerThanListProvider() {
        List<Movie> movies = createMovies();
        return Stream.of(
                Arguments.of(List.of(), 0L),
                Arguments.of(movies, 1L)
        );
    }

    private static List<Movie> createMovies() {
        List<Person> persons = createPersons();

        Movie testMovie1 = new Movie();
        testMovie1.setTitle("Action Fantasy Movie");
        testMovie1.setReleaseYear(1975);
        testMovie1.setLength(120);
        testMovie1.setGenres(List.of(Genre.ACTION, Genre.FANTASY));
        testMovie1.setWriters(persons.subList(0, 1));
        testMovie1.setDirectors(persons.subList(0, 1));

        Movie testMovie2 = new Movie();
        testMovie2.setTitle("Action SciFi Movie");
        testMovie2.setReleaseYear(1981);
        testMovie2.setLength(90);
        testMovie2.setGenres(List.of(Genre.ACTION, Genre.SCI_FI));
        testMovie2.setWriters(persons);
        testMovie2.setDirectors(persons);

        Movie testMovie3 = new Movie();
        testMovie3.setTitle("Drama Movie");
        testMovie3.setReleaseYear(1993);
        testMovie3.setLength(180);
        testMovie3.setGenres(List.of(Genre.DRAMA));
        testMovie3.setWriters(persons.subList(1, 2));
        testMovie3.setDirectors(persons.subList(1, 2));

        return List.of(testMovie1, testMovie2, testMovie3);
    }

    private static Movie createRomanceMovie() {
        List<Person> persons = createPersons();

        Movie romanceMovie = new Movie();
        romanceMovie.setTitle("Romance Movie");
        romanceMovie.setReleaseYear(2000);
        romanceMovie.setLength(90);
        romanceMovie.setGenres(List.of(Genre.ROMANCE));
        romanceMovie.setWriters(persons.subList(0, 1));
        romanceMovie.setDirectors(persons.subList(0, 1));
        return romanceMovie;
    }
    private static List<Person> createPersons() {
        Person person1 = new Person();
        person1.setName("John Smith");
        person1.setDateOfBirth(LocalDate.of(1970, 1, 1));
        person1.setBio("bio");

        Person person2 = new Person();
        person2.setName("Mary Fisher");
        person2.setDateOfBirth(LocalDate.of(1965, 1, 1));
        person2.setBio("bio2");
        return List.of(person1, person2);
    }
}
