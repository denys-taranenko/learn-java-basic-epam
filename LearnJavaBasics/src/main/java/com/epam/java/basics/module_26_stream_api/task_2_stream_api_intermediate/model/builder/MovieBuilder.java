package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.builder;

import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Genre;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Movie;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MovieBuilder {
    private String title;
    private String description;
    private int releaseYear;
    private List<Genre> genres;
    private int length;
    private List<Person> directors;
    private List<Person> writers;
    private List<Person> casts;

    public MovieBuilder() {}

    public MovieBuilder(String title) {
        this.title = title;
        description = "";
        releaseYear = 1900;
        genres = new ArrayList<>();
        length = 0;
        directors = new ArrayList<>();
        writers = new ArrayList<>();
        casts = new ArrayList<>();
    }

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MovieBuilder setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public MovieBuilder setGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public MovieBuilder setLength(int length) {
        this.length = length;
        return this;
    }

    public MovieBuilder setDirectors(List<Person> directors) {
        this.directors = directors;
        return this;
    }

    public MovieBuilder setWriters(List<Person> writers) {
        this.writers = writers;
        return this;
    }

    public MovieBuilder setCasts(List<Person> casts) {
        this.casts = casts;
        return this;
    }

    public Movie build() {
        Movie movie = new Movie();
        validateTitle(title);
        movie.setTitle(title);
        movie.setDescription(description);
        validateReleaseYear(releaseYear);
        movie.setReleaseYear(releaseYear);
        validateGenres(genres);
        movie.setGenres(genres);
        validateLength(length);
        movie.setLength(length);
        validateDirectors(directors);
        movie.setDirectors(directors);
        validateWriters(writers);
        movie.setWriters(writers);
        validateCasts(casts);
        movie.setCasts(casts);
        return movie;
    }

    private void validateTitle(String title) {
        if (title == null || title.isEmpty() || title.isBlank() || !title.matches("[a-zA-Z\\- 0-9:,;.]+")) {
            throw new IllegalArgumentException("Title (" + title + ") is not valid!");
        }
    }

    private void validateReleaseYear(int releaseYear) {
        if (releaseYear <= 1900) {
            throw new IllegalArgumentException("Release year (" + releaseYear + ") is not valid!");
        }
    }

    private void validateGenres(List<Genre> genres) {
        if (genres == null || genres.isEmpty()) {
            throw new IllegalArgumentException("Genres is not valid!");
        }
    }

    private void validateLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length (" + length + ") is not valid!");
        }
    }

    private void validateDirectors(List<Person> directors) {
        if (directors == null || directors.isEmpty()) {
            throw new IllegalArgumentException("Directors is not valid!");
        }
    }

    private void validateWriters(List<Person> writers) {
        if (writers == null || writers.isEmpty()) {
            throw new IllegalArgumentException("Writers is not valid!");
        }
    }

    private void validateCasts(List<Person> casts) {
        if (casts == null || casts.isEmpty()) {
            throw new IllegalArgumentException("Casts is not valid!");
        }
    }
}
