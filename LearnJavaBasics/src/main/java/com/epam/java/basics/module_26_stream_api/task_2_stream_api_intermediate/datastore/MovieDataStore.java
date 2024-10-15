package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.datastore;

import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Genre;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Movie;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Person;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.builder.MovieBuilder;
import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.builder.PersonBuilder;

import java.time.LocalDate;
import java.util.List;

public class MovieDataStore {

    private final List<Person> persons = List.of(
            // Terminator
            new PersonBuilder("James Cameron")
                    .setDateOfBirth(LocalDate.of(1954, 8, 16))
                    .setBio("He then wrote and directed The Terminator (1984), a futuristic action-thriller")
                    .build(),
            new PersonBuilder("Gale Anne Hurd")
                    .setDateOfBirth(LocalDate.of(1955, 10, 25))
                    .setBio("After graduating from Stanford University, she joined New World Pictures as executive assistant.s")
                    .build(),
            new PersonBuilder("William Wisher")
                    .setDateOfBirth(LocalDate.of(1950, 1, 1))
                    .setBio("William Wisher is known for Terminator 2: Judgment Day (1991), The Terminator (1984) and Judge Dredd (1995).")
                    .build(),
            new PersonBuilder("Arnold Schwarzenegger")
                    .setDateOfBirth(LocalDate.of(1947, 7, 30))
                    .setBio("With an almost unpronounceable surname and a thick Austrian accent")
                    .build(),
            new PersonBuilder("Linda Hamilton")
                    .setDateOfBirth(LocalDate.of(1956, 9, 26))
                    .setBio("Born in Salisbury, Maryland, USA, following high school Linda studied for two years at Washington College in Chestertown.")
                    .build(),
            new PersonBuilder("Michael Biehn")
                    .setDateOfBirth(LocalDate.of(1956, 7, 31))
                    .setBio("He starred in Cameron's subsequent films, Aliens (1986) and The Abyss (1989).")
                    .build(),

            // Blade Runner
            new PersonBuilder("Ridley Scott")
                    .setDateOfBirth(LocalDate.of(1937, 11, 30))
                    .setBio("Described by film producer Michael Deeley as \"the very best eye in the business\"")
                    .build(),
            new PersonBuilder("Hampton Fancher")
                    .setDateOfBirth(LocalDate.of(1938, 7, 18))
                    .setBio("He is an actor and writer, known for Blade Runner 2049 (2017), Blade Runner (1982) and The Minus Man (1999).")
                    .build(),
            new PersonBuilder("David Webb Peoples")
                    .setDateOfBirth(LocalDate.of(1940, 2, 9))
                    .setBio("He is a writer and editor, known for Unforgiven (1992), Blade Runner (1982) and 12 Monkeys (1995).")
                    .build(),
            new PersonBuilder("Philip K. Dick")
                    .setDateOfBirth(LocalDate.of(1928, 12, 16))
                    .setBio("Philip Kindred Dick was born in Chicago in December 1928, along with a twin sister, Jane.")
                    .build(),
            new PersonBuilder("Harrison Ford")
                    .setDateOfBirth(LocalDate.of(1942, 7, 13))
                    .setBio("After dropping out of Ripon College in Wisconsin, where he did some acting and later summer stock, he signed a Hollywood contract with Columbia and later Universal.")
                    .build(),
            new PersonBuilder("Rutger Hauer")
                    .setDateOfBirth(LocalDate.of(1944, 1, 23))
                    .setBio("Blond, blue-eyed, tall and handsome Dutch actor Rutger Hauer enjoyed an international reputation for playing everything.")
                    .build(),
            new PersonBuilder("Sean Young")
                    .setDateOfBirth(LocalDate.of(1959, 11, 20))
                    .setBio("She grew up with an older brother Donald Young III and a sister Cathleen Young in Cleveland, Ohio.")
                    .build(),

            // Star Wars
            new PersonBuilder("George Lucas")
                    .setDateOfBirth(LocalDate.of(1944, 5, 14))
                    .setBio("He planned to become a professional race-car driver.")
                    .build(),
            new PersonBuilder("Mark Hamill")
                    .setDateOfBirth(LocalDate.of(1951, 9, 25))
                    .setBio("Mark Hamill is best known for his portrayal of Luke Skywalker in the original Star Wars trilogy.")
                    .build(),
            new PersonBuilder("Carrie Fisher")
                    .setDateOfBirth(LocalDate.of(1956, 10, 21))
                    .setBio("She was an actress and writer known for Star Wars: Episode IV - A New Hope (1977), Star Wars: Episode V - The Empire Strikes Back (1980) and Star Wars: Episode VI - Return of the Jedi (1983).")
                    .build(),

            // Indiana Jones
            new PersonBuilder("Steven Spielberg")
                    .setDateOfBirth(LocalDate.of(1946, 12, 18))
                    .setBio("One of the most influential personalities in the history of cinema, Steven Spielberg is Hollywood's best known director.")
                    .build(),
            new PersonBuilder("Lawrence Kasdan")
                    .setDateOfBirth(LocalDate.of(1949, 1, 14))
                    .setBio("He wrote Raiders of the Lost Ark, The Bodyguard, The Empire Strikes Back, Return of the Jedi, The Force Awakens and Solo: A Star Wars Story.")
                    .build(),
            new PersonBuilder("Philip Kaufman")
                    .setDateOfBirth(LocalDate.of(1936, 10, 23))
                    .setBio("He won the Prix de la Nouvelle Critique at Cannes in 1965 for his film Goldstein (1964).")
                    .build(),
            new PersonBuilder("Karen Allen")
                    .setDateOfBirth(LocalDate.of(1951, 10, 5))
                    .setBio("Acting did not really cross Allen's mind until she was in her early 20s.")
                    .build(),
            new PersonBuilder("Paul Freeman")
                    .setDateOfBirth(LocalDate.of(1943, 1, 18))
                    .setBio("Probably one of Britain's most underrated actors, Paul Freeman has accumulated literally hundreds of screen credits over several decades.")
                    .build(),

            // The Magnificent Seven
            new PersonBuilder("John Sturges")
                    .setDateOfBirth(LocalDate.of(1910, 1, 3))
                    .setBio("John Sturges was an American film director, mostly remembered for his outstanding Western films.")
                    .build(),
            new PersonBuilder("William Roberts")
                    .setDateOfBirth(LocalDate.of(1913, 9, 4))
                    .setBio("He was a writer and producer, known for The Magnificent Seven (1960), Major Payne (1995) and The Donna Reed Show (1958).")
                    .build(),
            new PersonBuilder("Akira Kurosawa")
                    .setDateOfBirth(LocalDate.of(1910, 3, 23))
                    .setBio("After training as a painter (he storyboards his films as full-scale paintings), Kurosawa entered the film industry in 1936 as an assistant director.")
                    .build(),
            new PersonBuilder("Walter Bernstein")
                    .setDateOfBirth(LocalDate.of(1919, 8, 20))
                    .setBio("Blacklisted writer in the 1950s, a victim of the HUAC (House Un-American Activities Committee), he still continued to write under pseudonyms.")
                    .build(),
            new PersonBuilder("Yul Brynner")
                    .setDateOfBirth(LocalDate.of(1920, 7, 11))
                    .setBio("Exotic leading man of American films, famed as much for his completely bald head as for his performances.")
                    .build(),
            new PersonBuilder("Steve McQueen")
                    .setDateOfBirth(LocalDate.of(1930, 3, 24))
                    .setBio("He was the ultra-cool male film star of the 1960s.")
                    .build(),
            new PersonBuilder("Charles Bronson")
                    .setDateOfBirth(LocalDate.of(1921, 11, 3))
                    .setBio("The archetypal screen tough guy with weather-beaten features.")
                    .build(),

            // Seven Samurai
            new PersonBuilder("Shinobu Hashimoto")
                    .setDateOfBirth(LocalDate.of(1918, 4, 18))
                    .setBio("He was a writer and director, known for The Hidden Fortress (1958), Harakiri (1962) and Rashomon (1950).")
                    .build(),
            new PersonBuilder("Hideo Oguni")
                    .setDateOfBirth(LocalDate.of(1919, 8, 20))
                    .setBio("He was a writer and director, known for High and Low (1963), Ikiru (1952) and Ran (1985).")
                    .build(),
            new PersonBuilder("Toshiro Mifune")
                    .setDateOfBirth(LocalDate.of(1920, 4, 1))
                    .setBio("Toshiro Mifune achieved more worldwide fame than any other Japanese actor of his century. Mifune appeared in 16 of Kurosawa's films, most of which have become world-renowned classics.")
                    .build(),
            new PersonBuilder("Takashi Shimura")
                    .setDateOfBirth(LocalDate.of(1905, 3, 12))
                    .setBio("Japanese character actor Takashi Shimura was one of the finest film actors of the 20th century and a leading member of the \"stock company\" of master director Akira Kurosawa.")
                    .build(),
            new PersonBuilder("Keiko Tsushima")
                    .setDateOfBirth(LocalDate.of(1926, 2, 7))
                    .setBio("She was an actress, known for Seven Samurai (1954), Shiosai (1975) and Kyatsu o nigasuna (1956).")
                    .build()
    );


    private final List<Movie> movies = List.of(
            new MovieBuilder("The Terminator")
                    .setDescription("A human soldier is sent from 2029 to 1984 to stop an almost indestructible cyborg killing machine.")
                    .setGenres(List.of(Genre.ACTION, Genre.SCI_FI))
                    .setLength(107)
                    .setReleaseYear(1984)
                    .setDirectors(List.of(findPerson("James Cameron")))
                    .setWriters(List.of(findPerson("James Cameron"), findPerson("Gale Anne Hurd"), findPerson("William Wisher")))
                    .setCasts(List.of(findPerson("Arnold Schwarzenegger"), findPerson("Linda Hamilton"), findPerson("Michael Biehn")))
                    .build(),
            new MovieBuilder("Blade Runner")
                    .setDescription("A blade runner must pursue and terminate four replicants who stole a ship in space and have returned to Earth to find their creator.")
                    .setGenres(List.of(Genre.ACTION, Genre.DRAMA, Genre.SCI_FI))
                    .setLength(117)
                    .setReleaseYear(1982)
                    .setDirectors(List.of(findPerson("Ridley Scott")))
                    .setWriters(List.of(findPerson("Hampton Fancher"), findPerson("David Webb Peoples"), findPerson("Philip K. Dick")))
                    .setCasts(List.of(findPerson("Harrison Ford"), findPerson("Rutger Hauer")))
                    .build(),
            new MovieBuilder("Star Wars")
                    .setDescription("Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy")
                    .setGenres(List.of(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY))
                    .setLength(121)
                    .setReleaseYear(1977)
                    .setDirectors(List.of(findPerson("George Lucas")))
                    .setWriters(List.of(findPerson("George Lucas")))
                    .setCasts(List.of(findPerson("Mark Hamill"), findPerson("Harrison Ford"), findPerson("Carrie Fisher")))
                    .build(),
            new MovieBuilder("Indiana Jones")
                    .setDescription("In 1936, archaeologist and adventurer Indiana Jones is hired by the U.S. government to find the Ark of the Covenant")
                    .setGenres(List.of(Genre.ACTION, Genre.ADVENTURE))
                    .setLength(115)
                    .setReleaseYear(1981)
                    .setDirectors(List.of(findPerson("Steven Spielberg")))
                    .setWriters(List.of(findPerson("Lawrence Kasdan"), findPerson("George Lucas"), findPerson("Philip Kaufman")))
                    .setCasts(List.of(findPerson("Harrison Ford"), findPerson("Karen Allen"), findPerson("Paul Freeman")))
                    .build(),
            new MovieBuilder("The Magnificent Seven")
                    .setDescription("Seven gunfighters are hired by Mexican peasants to liberate their village from oppressive bandits.")
                    .setGenres(List.of(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA))
                    .setLength(128)
                    .setReleaseYear(1960)
                    .setDirectors(List.of(findPerson("John Sturges")))
                    .setWriters(List.of(findPerson("William Roberts"), findPerson("Akira Kurosawa"), findPerson("Walter Bernstein")))
                    .setCasts(List.of(findPerson("Yul Brynner"), findPerson("Steve McQueen"), findPerson("Charles Bronson")))
                    .build(),
            new MovieBuilder("Seven Samurai")
                    .setDescription("Farmers from a village exploited by bandits hire a veteran samurai for protection, who gathers six other samurai to join him.")
                    .setGenres(List.of(Genre.ACTION, Genre.DRAMA))
                    .setLength(207)
                    .setReleaseYear(1954)
                    .setDirectors(List.of(findPerson("Akira Kurosawa")))
                    .setWriters(List.of(findPerson("Akira Kurosawa"), findPerson("Shinobu Hashimoto"), findPerson("Hideo Oguni")))
                    .setCasts(List.of(findPerson("Toshiro Mifune"), findPerson("Takashi Shimura"), findPerson("Keiko Tsushima")))
                    .build()
    );

    public List<Person> getPersons() {
        return persons;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    private Person findPerson(String name) {
        return persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .get();
    }
}
