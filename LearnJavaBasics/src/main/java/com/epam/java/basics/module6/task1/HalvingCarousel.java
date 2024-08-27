package com.epam.java.basics.module6.task1;

import com.epam.java.basics.module5.task4.CarouselRun;
import com.epam.java.basics.module5.task4.DecrementingCarousel;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(int capacity) {
        super(capacity);
    }

    @Override
    public boolean addElement(int element) {
        return super.addElement(element);
    }

    @Override
    public CarouselRun run() {
        if (isRun()) {
            return null;
        }

        setRun(true);
        return new CarouselRun(getElements()) {
            @Override
            public int next() {
                if (isFinished()) {
                    return -1;
                }
                while (true) {
                    if (getCurrentIndex() >= getElements().length) {
                        setCurrentIndex(0);
                    }
                    if (getElements()[getCurrentIndex()] > 0) {
                        int currentValue = getElements()[getCurrentIndex()];
                        getElements()[getCurrentIndex()] /= 2;
                        setCurrentIndex(getCurrentIndex() + 1);
                        return currentValue;
                    }
                    if (getElements()[getCurrentIndex()] == 0) {
                        setCurrentIndex(getCurrentIndex() + 1);
                    }
                }
            }
        };
    }
}