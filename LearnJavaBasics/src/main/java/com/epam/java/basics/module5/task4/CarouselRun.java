package com.epam.java.basics.module5.task4;

public class CarouselRun {
    private final int[] elements;
    private int currentIndex;

    public CarouselRun(int[] elements) {
        this.elements = elements.clone();
        this.currentIndex = 0;
    }


    public int next() {
        if (isFinished()) {
            return -1;
        }

        while (true) {
            if (elements[currentIndex] > 0) {
                int currentValue = elements[currentIndex];
                elements[currentIndex]--;
                currentIndex = (currentIndex + 1) % elements.length;
                return currentValue;
            } else {
                currentIndex = (currentIndex + 1) % elements.length;
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
}