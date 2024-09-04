package com.epam.java.basics.module_5_classes.task_4_decrementing_carousel;

public class CarouselRun {
    private final int[] elements;
    private int currentIndex;

    public CarouselRun(int[] elements) {
        this.elements = elements;
        this.currentIndex = 0;
    }

    public int next() {
        if (isFinished()) {
            return -1;
        }
        while (true) {
            if (currentIndex >= elements.length) {
                currentIndex = 0;
            }
            if (elements[currentIndex] > 0) {
                int currentValue = elements[currentIndex];
                elements[currentIndex]--;
                currentIndex++;
                return currentValue;
            }
            if (elements[currentIndex] == 0) {
                currentIndex++;
            }
        }
    }

    public boolean isFinished() {
        for (int element : elements) {
            if (element > 0) {
                return false;
            }
        }
        return true;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}