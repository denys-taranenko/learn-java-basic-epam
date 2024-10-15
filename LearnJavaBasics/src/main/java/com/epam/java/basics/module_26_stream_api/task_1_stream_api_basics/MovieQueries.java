package com.epam.java.basics.module_26_stream_api.task_1_stream_api_basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieQueries {
    private List<String> movies = new ArrayList<>();

    public MovieQueries(List<String> movies) {
        if (movies == null) {
            throw new IllegalArgumentException();
        }
        this.movies = movies;
    }

    public long getNumberOfMovies() {
        return movies.stream()
                .count();
    }

    public long getNumberOfMoviesThatStartsWith(String start) {
        return movies.stream()
                .filter(s -> s.startsWith(start))
                .count();
    }

    public long getNumberOfMoviesThatStartsWithAndEndsWith(String start, String end) {
        return movies.stream()
                .filter(s -> s.startsWith(start))
                .filter(s -> s.endsWith(end))
                .count();
    }

    public List<Integer> getLengthOfTitleOfMovies() {
        return movies.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public int getNumberOfLettersInShortestTitle() {
        return movies.stream()
                .mapToInt(String::length)
                .min()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Optional<String> getFirstTitleThatContainsThreeWords() {
        return movies.stream()
                .filter(s -> s.matches("^ *\\w+( +\\w+){2} *$"))
                .findFirst();
    }

    public List<String> getFirstFourTitlesThatContainAtLeastTwoWords() {
        return movies.stream()
                .filter(s -> s.matches("^ *\\w+( +\\w+)+ *$"))
                .limit(4)
                .collect(Collectors.toList());
    }

    public void printAllTitleToConsole() {
        String result = movies.stream()
                .map(String::trim)
                .collect(Collectors.joining(" "));
        System.out.print(result.trim());
    }
}
