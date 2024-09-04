package com.epam.java.basics.module_6_introduction_to_oop.task_2_gradually_decreasing_carousel;

import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.CarouselRun;
import com.epam.java.basics.module_5_classes.task_4_decrementing_carousel.DecrementingCarousel;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    private final int[] decrementArray;
    
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
        this.decrementArray = new int[capacity];
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

                    if (getElements()[getCurrentIndex()] <= 0) {
                        setCurrentIndex(getCurrentIndex() + 1);

                        if (getCurrentIndex() >= getElements().length) {
                            setCurrentIndex(0);
                        }
                        continue;
                    }

                    if (getElements()[getCurrentIndex()] > 0) {
                        int currentValue = getElements()[getCurrentIndex()];

                        getElements()[getCurrentIndex()] -= ++decrementArray[getCurrentIndex()];
                        setCurrentIndex(getCurrentIndex() + 1);

                        return currentValue;
                    }
                }
            }
        };
    }
}