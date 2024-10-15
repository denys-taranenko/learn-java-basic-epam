package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate;

import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Genre;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Movie;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Person;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieQueries {
    private final List<Movie> movies;

    public MovieQueries(List<Movie> movies) {
        if (movies == null) {
            throw new IllegalArgumentException();
        }
        this.movies = movies;
    }


    public boolean checkGenreOfAllMovies(Genre genre) {
        return movies.stream()
                .allMatch(movie -> movie.getGenres().stream()
                        .anyMatch(currentGenre -> currentGenre.equals(genre)));
    }

    public boolean checkGenreOfAnyMovies(Genre genre) {
        return movies.stream()
                .anyMatch(movie -> movie.getGenres().stream()
                        .anyMatch(currentGenre -> currentGenre.equals(genre)));
    }

    public boolean checkMovieIsDirectedBy(Person person) {
        return movies.stream()
                .anyMatch(movie -> movie.getDirectors().stream()
                        .anyMatch(currentPerson -> currentPerson.equals(person)));

    }

    public int calculateTotalLength() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .sum();
    }

    public long moviesLongerThan(int minutes) {
        return movies.stream()
                .filter(movie -> movie.getLength() > minutes)
                .count();
    }

    public List<Person> listOfWriters() {
        return movies.stream()
                .flatMap(movie -> movie.getWriters().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public String[] movieTitlesWrittenBy(Person person) {
        return movies.stream()
                .filter(movie -> movie.getWriters().stream()
                        .anyMatch(currentPerson -> currentPerson.equals(person)))
                .map(Movie::getTitle)
                .toArray(String[]::new);
    }

    public List<Integer> listOfLength() {
        return movies.stream()
                .map(Movie::getLength)
                .collect(Collectors.toList());
    }

    public Movie longestMovie() {
        return movies.stream()
                .max(Comparator.comparing(Movie::getLength))
                .orElseThrow(IllegalArgumentException::new);
    }

    public Movie oldestMovie() {
        return movies.stream()
                .min(Comparator.comparingInt(Movie::getReleaseYear))
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Movie> sortedListOfMoviesBasedOnReleaseYear() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseYear))
                .toList();
    }

    public List<Movie> sortedListOfMoviesBasedOnTheDateOfBirthOfOldestDirectorsOfMovies() {
        return movies.stream()
                .map(movie -> new AbstractMap.SimpleEntry<>(movie,
                        movie.getDirectors().stream()
                                .map(Person::getDateOfBirth)
                                .min(Comparator.naturalOrder())
                                .orElse(null)))
                .filter(entry -> entry.getValue() != null)
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Movie> moviesReleasedEarlierThan(int releaseYear) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() <= releaseYear)
                .collect(Collectors.toList());
    }
}
