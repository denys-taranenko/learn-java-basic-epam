package com.epam.java.basics.module_5_classes.task_4_decrementing_carousel;

public class DecrementingCarousel {
    private final int[] elements;
    private final int capacity;
    private int currentIndex;
    private boolean isRun;

    public DecrementingCarousel(int capacity) {
        this.elements = new int[capacity];
        this.capacity = capacity;
        this.currentIndex = 0;
        this.isRun = false;
    }

    public boolean addElement(int element) {
        if (element <= 0) {
            return false;
        }
        if (currentIndex >= capacity) {
            return false;
        }
        if (isRun) {
            return false;
        }
        elements[currentIndex] = element;
        currentIndex++;
        return true;
    }

    public CarouselRun run() {
        if (isRun) {
            return null;
        }

        isRun = true;

        return new CarouselRun(elements);
    }

    public int[] getElements() {
        return elements;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }
}