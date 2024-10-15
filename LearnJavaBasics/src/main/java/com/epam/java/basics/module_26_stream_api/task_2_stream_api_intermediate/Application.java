package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate;

import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.datastore.MovieDataStore;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Genre;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Person;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {

        MovieDataStore store = new MovieDataStore();

        MovieQueries app = new MovieQueries(store.getMovies());

        String personName = "George Lucas";
        Person person = store.getPersons()
                .stream()
                .filter(p -> p.getName().equals(personName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Person not found by name: " + personName)) ;

        // allMatch
        System.out.println("Check whether the genre of all movies is Action!");
        System.out.println(app.checkGenreOfAllMovies(Genre.ACTION));

        // anyMatch
        System.out.println("Check whether there is an Adventurer movie in the list!");
        System.out.println(app.checkGenreOfAnyMovies(Genre.ADVENTURE));

        System.out.println("Are there any movie which is directed by George Lucas?");
        System.out.println(app.checkMovieIsDirectedBy(person));

        // count, sum, IntStream
        System.out.println("Calculate the total length of movies in minutes!");
        System.out.println(app.calculateTotalLength());

        System.out.println("How many movies are longer than 2 hours?");
        System.out.println(app.moviesLongerThan(120));

        // distinct, flatMap
        System.out.println("Get the list of writers of all movies!");
        System.out.println(app.listOfWriters());

        // map, IntStream
        System.out.println("Get an array of the titles of movies that are written by a George Lucas!");
        System.out.println(Arrays.toString(app.movieTitlesWrittenBy(person)));

        System.out.println("Get a list of the length of movies!");
        System.out.println(app.listOfLength());

        // min, max
        System.out.println("Find the longest movie!");
        System.out.println(app.longestMovie());

        System.out.println("Which movie is the oldest?");
        System.out.println(app.oldestMovie());

        // sorted, Comparator
        System.out.println("Get a sorted list of movies based on their release year!");
        System.out.println(app.sortedListOfMoviesBasedOnReleaseYear());

        System.out.println("Get a sorted list of movies based on the date of birth of the oldest director of each movie!");
        System.out.println(app.sortedListOfMoviesBasedOnTheDateOfBirthOfOldestDirectorsOfMovies());

        // takeWhile
        System.out.println("Get all the movies which are released earlier than 1980 inclusively!");
        System.out.println(app.moviesReleasedEarlierThan(1980));
    }
}
