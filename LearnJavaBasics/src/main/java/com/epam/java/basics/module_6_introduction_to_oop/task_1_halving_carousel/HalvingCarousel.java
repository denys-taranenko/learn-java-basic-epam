package com.epam.java.basics.module_6_introduction_to_oop.task_1_halving_carousel;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.CarouselRun;
import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.DecrementingCarousel;

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