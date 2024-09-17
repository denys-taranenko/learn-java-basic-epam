package com.epam.java.basics.module_17_lists_and_queues.task_1_simple_array_list;

import java.util.Optional;

public class SimpleArrayListImpl implements SimpleArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int FACTOR_MULTIPLIER = 2;
    private static final double INCREASE_LOAD_FACTOR = 0.75;
    private static final double DECREASE_LOAD_FACTOR = 0.4;

    private Object[] elements;
    private int size;

    public SimpleArrayListImpl() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (size >= elements.length * INCREASE_LOAD_FACTOR) {
            increaseCapacity();
        }

        elements[size++] = element;
        return true;
    }

    @Override
    public int capacity() {
        if (size >= elements.length * INCREASE_LOAD_FACTOR) {
            increaseCapacity();
        }
        return elements.length;
    }

    @Override
    public boolean decreaseCapacity() {
        if (size <= elements.length * DECREASE_LOAD_FACTOR) {
            int newCapacity = size * FACTOR_MULTIPLIER;
            if (newCapacity == DEFAULT_CAPACITY) {
                newCapacity = DEFAULT_CAPACITY;
            }
            copyArray(elements, newCapacity);
            return true;
        }
        return false;
    }

    private void increaseCapacity() {
        int newCapacity = (int) (elements.length * FACTOR_MULTIPLIER * INCREASE_LOAD_FACTOR);
        copyArray(elements, newCapacity);
    }

    private void copyArray(Object[] oldArray, int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        if (size >= 0) System.arraycopy(oldArray, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Optional<Object> remove(Object el) {
        if (el == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(el)) {
                Object removedElement = elements[i];
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return Optional.of(removedElement);
            }
        }
        return Optional.empty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            result += elements[i].toString();
        }
        result += "]";
        return result;
    }
}