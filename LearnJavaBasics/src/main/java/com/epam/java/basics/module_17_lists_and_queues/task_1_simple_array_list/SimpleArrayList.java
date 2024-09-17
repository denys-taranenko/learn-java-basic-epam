package com.epam.java.basics.module_17_lists_and_queues.task_1_simple_array_list;

import java.util.Optional;

public interface SimpleArrayList {

    /**
     * Returns the number of elements.
     *
     * @return the number of elements in this list.
     */
    int size();

    /**
     * Makes a string representation of this list.
     *
     * @return a string representation of this list.
     */
    String toString();

    /**
     * Appends the specified element to the end of this list.
     * This method must increase the current capacity of the internal
     * array if there is no free space to store the new element.<br>
     * {@code newCapacity = elements.length * 0.75 * 2}
     *
     * @param el element to be appended to this list
     * @return {@code true} if this list was changed {@code false} otherwise.
     * Because this list must provide capacity growing it's assumed
     * that this method always returns {@code true}.
     * @throws NullPointerException if the argument is {@code null}
     */
    boolean add(Object el);

    /**
     * @return the current length of the list
     */
    int capacity();

    /**
     * Decreases the capacity of the list if it is 40% full or less
     *
     * @return {@code true} if the length of the list was decreased,
     * otherwise {@code false}
     */
    boolean decreaseCapacity();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()}).
     */

    Object get(int index);


    /**
     * Searches and removes the specified element. Shifts any
     * subsequent elements to the left.
     *
     * @param el the element wrapped to {@code Optional}
     *           if its was found or {@code Optional.empty()} otherwise.
     * @return the element that was removed from this list.
     * @throws NullPointerException if the argument is {@code null}
     */
    Optional<Object> remove(Object el);
}