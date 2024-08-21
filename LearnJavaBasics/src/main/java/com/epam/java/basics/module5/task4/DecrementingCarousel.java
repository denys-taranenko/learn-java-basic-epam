package com.epam.java.basics.module5.task4;

public class DecrementingCarousel {
    private final int[] elements;
    private final int capacity;
    private int currentIndex;
    private boolean runCalled;

    public DecrementingCarousel(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        elements = new int[capacity];
        currentIndex = 0;
        runCalled = false;
    }

    public boolean addElement(int element) {
        if (element <= 0) {
            return false;
        }
        if (runCalled) {
            return false;
        }
        if (currentIndex == capacity) {
            return false;
        }

        elements[currentIndex] = element;
        currentIndex++;

        return true;
    }

    public CarouselRun run() {
        if (runCalled) {
            return null;
        }

        runCalled = true;

        return new CarouselRun(elements);
    }
}