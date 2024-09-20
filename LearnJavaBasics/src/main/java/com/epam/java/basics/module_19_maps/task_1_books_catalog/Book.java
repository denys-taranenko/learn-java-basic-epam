package com.epam.java.basics.module_19_maps.task_1_books_catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final List<String> genres;
    private final BigDecimal cost;

    public Book(String title, List<String> genres, BigDecimal cost) {
        this.title = title;
        this.genres = genres;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(genres, book.genres) && Objects.equals(cost, book.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genres, cost);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                ", cost=" + (cost == null ? "unavailable" : cost) +
                '}';
    }

    /**
     * The natural ordering is by title in ascending order,
     * then by cost in ascending order with {@code null}s at the end.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Book o) {
        if (o.equals(null)) {
            throw new NullPointerException();
        }

        if (getCost() == null) {
            return 1;
        }

        int titleCompare = getTitle().compareTo(o.getTitle());
        return titleCompare == 0 ? getCost().compareTo(o.getCost()) : titleCompare;
    }
}
