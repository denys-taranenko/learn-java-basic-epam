package com.epam.java.basics.module_17_lists_and_queues.task_2_doubly_linked_list;

import java.util.Optional;

public interface DoublyLinkedList {

    boolean addFirst(Object element);

    boolean addLast(Object element);

    void delete(int index);

    Optional<Object> remove(Object element);

    boolean set(int index, Object element);

    int size();

    Object[] toArray();

    String toString();
}
