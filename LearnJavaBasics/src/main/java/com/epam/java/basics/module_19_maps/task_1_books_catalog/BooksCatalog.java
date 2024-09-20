package com.epam.java.basics.module_19_maps.task_1_books_catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BooksCatalog {
    private static final String EOL = "\n";
    private final Map<Author, List<Book>> catalog;

    public BooksCatalog() {
        this.catalog = new TreeMap<>();
    }

    public BooksCatalog(Map<Author, List<Book>> catalog) {
        validateNotNull(catalog);
        this.catalog = catalog;
    }

    /**
     * Returns a List of books of the specified author.
     *
     * @param author the author of books to search for.
     * @return a list of books or {@code null}
     * if there is no such author in the catalog.
     */
    public List<Book> findByAuthor(Author author) {
        validateNotNull(author);

        List<Book> booksOfAuthor = new ArrayList<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            if (entry.getKey().equals(author)) {
                booksOfAuthor.addAll(entry.getValue());
            }
        }
        return booksOfAuthor.isEmpty() ? null : booksOfAuthor;
    }

    /**
     * @return the string representation of all authors
     * separated by the current operating system {@code lineSeparator}.
     */
    public String getAllAuthors() {
        List<Author> authors = new ArrayList<>(catalog.keySet());
        Collections.sort(authors);

        StringBuilder stringBuilder = new StringBuilder();
        for (Author author : authors) {
            stringBuilder.append(author).append(EOL);
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Searches for pairs of (author, book) by the book title.
     * The pair must be included in the resulting map if the
     * book title contains the specified string matched ignore case.
     * All authors of the book must be specified in the
     * book authors list.
     *
     * @param pattern the string to search for in the book title.
     * @return the map which contains all found books and their authors.
     * It must be sorted by titles of books, if the titles match,
     * by increasing cost.
     */
    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        validateNotNull(pattern);

        Map<Book, List<Author>> authorsByBookTitle = new TreeMap<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            Author author = entry.getKey();
            for (Book book : entry.getValue()) {
                if (book.getTitle().toLowerCase().contains(pattern.toLowerCase())) {
                    if (!authorsByBookTitle.containsKey(book)) {
                        authorsByBookTitle.put(book, new ArrayList<>());
                    }
                    authorsByBookTitle.get(book).add(author);
                }
            }
        }

        for (List<Author> authors : authorsByBookTitle.values()) {
            Collections.sort(authors);
        }
        return authorsByBookTitle;
    }

    /**
     * Searches for all books whose genre list contains the specified string.
     * The book must be included in the resulting list if at least
     * one genre of the book contains the specified pattern ignoring case.
     *
     * @param pattern the string to search for in the book genre list.
     * @return a set of books sorted using natural ordering.
     * @see Book class.
     */
    public Set<Book> findBooksByGenre(String pattern) {
        validateNotNull(pattern);

        Set<Book> booksByGenre = new TreeSet<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book book : entry.getValue()) {
                for (String genre : book.getGenres()) {
                    if (genre.toLowerCase().contains(pattern.toLowerCase())) {
                        booksByGenre.add(book);
                        break;
                    }
                }
            }
        }
        return booksByGenre.isEmpty() ? null : booksByGenre;
    }

    /**
     * Searches for authors of the specified book.
     *
     * @param book the book.
     * @return a list of authors of the specified book.
     * @throws NullPointerException if the parameter is {@code null}
     */
    public List<Author> findAuthorsByBook(Book book) {
        validateNotNull(book);

        List<Author> authorsByBook = new ArrayList<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            if (entry.getValue().contains(book)) {
                authorsByBook.add(entry.getKey());
            }
        }

        Collections.sort(authorsByBook);
        return authorsByBook;
    }

    @Override
    public String toString() {
        Map<Author, List<Book>> sortedCatalog = new TreeMap<>(catalog);
        return sortedCatalog.toString();
    }

    private void validateNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }
}
