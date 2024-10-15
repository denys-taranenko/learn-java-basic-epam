package com.epam.java.basics.module_26_stream_api.task_1_stream_api_basics;

import java.util.List;

public class Application {

    private static final List<String> MOVIE_LIST = List.of("Terminator", "Blade Runner", "Star Wars",
            "Indiana Jones", "Friends", "The Magnificent Seven", "The Dark Knight", "The Lord of the Rings: The Return of the King",
            "Pulp Fiction");

    public static void main(String[] args) {
        MovieQueries app = new MovieQueries(MOVIE_LIST);
        System.out.println("Count the titles in the list!");
        System.out.println(app.getNumberOfMovies());
        System.out.println("Count the titles starting with 'The'!");
        System.out.println(app.getNumberOfMoviesThatStartsWith("The"));
        System.out.println("Count the titles starting with 'The' and ends with 'g'!");
        System.out.println(app.getNumberOfMoviesThatStartsWithAndEndsWith("The", "g"));
        System.out.println("Return the length of titles as a list!");
        System.out.println(app.getLengthOfTitleOfMovies());
        System.out.println("Return the length of shortest title!");
        System.out.println(app.getNumberOfLettersInShortestTitle());
        System.out.println("Find the first movie which contains 3 word!");
        System.out.println(app.getFirstTitleThatContainsThreeWords());
        System.out.println("Find the first 4 titles which contain 2 or more words!");
        System.out.println(app.getFirstFourTitlesThatContainAtLeastTwoWords());
        System.out.println("Print each title one by one!");
        app.printAllTitleToConsole();
    }
}
