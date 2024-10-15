package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model;

import java.util.List;
import java.util.Objects;

public class Movie {
    private String title;
    private String description;
    private int releaseYear;
    private List<Genre> genres;
    private int length;
    private List<Person> directors;
    private List<Person> writers;
    private List<Person> casts;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getWriters() {
        return writers;
    }

    public void setWriters(List<Person> writers) {
        this.writers = writers;
    }

    public List<Person> getCasts() {
        return casts;
    }

    public void setCasts(List<Person> casts) {
        this.casts = casts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return releaseYear == movie.releaseYear &&
                length == movie.length &&
                Objects.equals(title, movie.title) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(genres, movie.genres) &&
                Objects.equals(directors, movie.directors) &&
                Objects.equals(writers, movie.writers) &&
                Objects.equals(casts, movie.casts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, releaseYear, genres, length, directors, writers, casts);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + genres +
                ", length=" + length +
                ", directors=" + directors +
                ", writers=" + writers +
                ", casts=" + casts +
                '}';
    }
}
