package com.epam.java.basics.module_19_maps.task_1_books_catalog;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BooksCatalogTest {

    static final String EOL = "\n";
    static final String DATA_FILE_NAME = "src/test/resources/maps/books.csv";
    private static final String AUTHORS_CSV = "src/test/resources/maps/authors.csv";
    private static final String TITLES_CSV = "src/test/resources/maps/titles.csv";
    private static final String GENRES_CSV = "src/test/resources/maps/genres.csv";
    private static final String BOOK_AUTHOR_CSV = "src/test/resources/maps/bookauthor.csv";
    private static final String COMPARE_BOOKS_CSV = "src/test/resources/maps/comparebooks.csv";
    static BooksCatalog catalog;
    static Map<Author, List<Book>> data;

    @BeforeAll
    static void getAuthorListMap() {
        data = Util.getData(DATA_FILE_NAME);
        catalog = new BooksCatalog(data);
    }

    @Test
    void testFindByAuthor() {
        data.forEach((k, v) -> assertIterableEquals(v, catalog.findByAuthor(k)));

        List<Book> actual = catalog.findByAuthor(new Author("John", "Doe"));
        assertNull(actual,
                "Expected: 'null' but was: " + actual);
    }

    // also checks Authors compareTo
    @ParameterizedTest
    @CsvFileSource(files = {AUTHORS_CSV}, delimiter = ';')
    void testGetAllAuthors(String data) {
        Author[] authors = Arrays.stream(data.split("~"))
                .map(a -> a.split(","))
                .map(a -> new Author(a[0], a[1]))
                .toArray(Author[]::new);

        Map<Author, List<Book>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Arrays.stream(authors)
                .map(a -> new AbstractMap.SimpleEntry<Author, List<Book>>(a, List.of()))
                .forEach(entry -> {
                    map.put(entry.getKey(), entry.getValue());
                    list.add(entry.getKey().toString());
                });
        String expected = list.stream().distinct().collect(Collectors.joining(EOL));
        BooksCatalog booksCatalog = new BooksCatalog(map);
        String actual = booksCatalog.getAllAuthors();
        assertEquals(expected, actual,
                "Probably 'compareTo()' needs a revision.");
    }

    @ParameterizedTest
    @CsvFileSource(files = {TITLES_CSV}, delimiterString = ";")
    void testFindAuthorsByBookTitle(String word/*, String title*/) {
        data = Util.getData(DATA_FILE_NAME);
        Map<Book, List<Author>> books = new TreeMap<>();
        try {
            data.values().stream()
                    .flatMap(List::stream)
                    .filter(b -> b.getTitle().matches("(?i)^.*" + word + ".*$"))
                    .distinct()
                    .forEach(b -> books.merge(b, data.entrySet().stream()
                                    .filter(e -> e.getValue().contains(b))
                                    .map(Map.Entry::getKey)
                                    .distinct()
                                    .sorted()
                                    .toList(), (to, from) -> {
                                to.addAll(from);
                                return to;
                            })
                    );
        } catch (UnsupportedOperationException e) {
            fail("Probably the Book#compareT() needs a revision. " +
                    "Book#cost can contain nulls.");
        }
        Map<Book, List<Author>> actual = catalog.findAuthorsByBookTitle(word);
        assertIterableEquals(books.entrySet(), actual.entrySet(),
                "Expected: " + books.entrySet() + ", but was: " + actual.entrySet());
    }

    @ParameterizedTest
    @CsvFileSource(files = {GENRES_CSV}, delimiter = '~')
    void testFindBooksByGenre(String genre, String books) {
        String[] split = books.split("\\^");
        List<Book> expected = Arrays.stream(split)
                .map(s -> s.split(";"))
                .map(b -> new Book(b[0], List.of(b[1].split(", ")), new BigDecimal(b[2])))
                .toList();
        Set<Book> actual = catalog.findBooksByGenre(genre);
        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = {BOOK_AUTHOR_CSV}, delimiter = ';')
    void testFindAuthorsByBook(String title, String genres, String cost, String authors) {
        Book book = new Book(title, List.of(genres.split(", ")), new BigDecimal(cost));
        List<Author> actual = catalog.findAuthorsByBook(book);
        List<Author> expected = Arrays.stream(authors.split(", "))
                .map(s -> {
                    if (s.isEmpty()) {
                        return null;
                    }
                    String[] author = s.split(",");
                    return new Author(author[0], author[1]);
                })
                .filter(Objects::nonNull)
                .toList();
        assertEquals(expected, actual);
    }

    @Test
    void testFindAuthorsByBookShouldThrow() {
        assertThrows(NullPointerException.class, () -> new BooksCatalog(data).findAuthorsByBook(null));
    }

    @Test
    void testToString() {
        assertEquals(new TreeMap<>(data).toString(), catalog.toString());
    }

    @ParameterizedTest
    @CsvFileSource(files = COMPARE_BOOKS_CSV, delimiter = ';')
    void testBookCompareTo(String sTitles, String sGenres, String sCosts) {
        String[] titles = sTitles.split("~");
        String[] genres = sGenres.split("~");
        BigDecimal[] costs = Arrays.stream(sCosts.split("~"))
                .map(s -> s == null || s.isBlank() ? null : new BigDecimal(s))
                .toArray(BigDecimal[]::new);
        List<Book> expected = new ArrayList<>();
        IntStream.range(0, titles.length).forEach(i -> expected.add(new Book(titles[i],
                List.of(genres[i].split(",")), costs[i])));
        Set<Book> actual = new TreeSet<>(expected);
        assertIterableEquals(expected, actual,
                "\nExpected: " + expected + "\nbut was : " + actual + '\n');
    }
}
