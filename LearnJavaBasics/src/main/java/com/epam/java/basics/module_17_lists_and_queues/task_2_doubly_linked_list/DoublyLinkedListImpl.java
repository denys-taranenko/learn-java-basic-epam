package com.epam.java.basics.module_17_lists_and_queues.task_2_doubly_linked_list;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        Object element;
        Node next;
        Node prev;

        Node(Object obj, Node prev, Node next) {
            this.element = obj;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean addFirst(Object element) {
        if (element == null) {
            return false;
        }

        Node newNode = new Node(element, null, head);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        return true;
    }

    @Override
    public boolean addLast(Object element) {
        if (element == null) {
            return false;
        }

        Node newNode = new Node(element, tail, null);

        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        } else {
            head = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            tail = currentNode.prev;
        }
    }

    @Override
    public Optional<Object> remove(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.element.equals(element)) {
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }

                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                } else {
                    tail = currentNode.prev;
                }

                return Optional.of(currentNode.element);
            }
            currentNode = currentNode.next;
        }
        return Optional.empty();
    }

    @Override
    public boolean set(int index, Object element) throws IndexOutOfBoundsException {
        if (element == null) {
            return false;
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.element = element;
        return true;
    }

    @Override
    public int size() {
        int elementsCount = 0;
        Node currentNode = head;

        while (currentNode != null) {
            elementsCount++;
            currentNode = currentNode.next;
        }
        return elementsCount;
    }

    @Override
    public Object[] toArray() {
        Object[] resultArray = new Object[size()];
        Node currentNode = head;

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = currentNode.element;
            currentNode = currentNode.next;
        }
        return resultArray;
    }

    @Override
    public String toString() {
        String result = "";
        Node currentNode = head;

        while (currentNode != null) {
            result += currentNode.element;
            if (currentNode.next != null) {
                result += " ";
            }
            currentNode = currentNode.next;
        }
        return result;
    }
}
