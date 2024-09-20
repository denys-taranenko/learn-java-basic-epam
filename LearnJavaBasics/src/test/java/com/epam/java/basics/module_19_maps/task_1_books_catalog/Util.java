package com.epam.java.basics.module_19_maps.task_1_books_catalog;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Util {
    static Map<Author, List<Book>> getData(String fName) {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(Paths.get(fName));
        } catch (IOException e) {
            Assertions.fail("Error read: " + fName + ". " + e.getMessage());
        }
        Map<Author, List<Book>> map = new HashMap<>();
        strings.forEach(line -> {
            String[] values = line.split(";");
            try {
                List<Book> books = new ArrayList<>();
                books.add(new Book(values[0],
                        Arrays.asList(values[1].split(",")),
                        new BigDecimal(values[2])));
                map.merge(new Author(values[3], values[4]), books, (books1, books2) -> {
                    books1.addAll(books2);
                    return books1;
                });
            } catch (Exception e) {
                System.err.println(e.getMessage() + ": " + Arrays.toString(values));
            }
        });
        return map;
    }
}
