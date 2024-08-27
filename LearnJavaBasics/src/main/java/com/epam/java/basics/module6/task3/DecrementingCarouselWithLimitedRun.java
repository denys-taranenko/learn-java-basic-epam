package com.epam.java.basics.module6.task3;

import com.epam.java.basics.module5.task4.CarouselRun;
import com.epam.java.basics.module5.task4.DecrementingCarousel;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    private final int actionLimit;
    private int currentLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
        this.currentLimit = 0;
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
            public boolean isFinished() {
                for (int element : getElements()) {
                    if (element > 0 && currentLimit != actionLimit) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public int next() {
                if (isFinished()) {
                    return -1;
                }

                while (currentLimit != actionLimit) {
                    if (getCurrentIndex() >= getElements().length) {
                        setCurrentIndex(0);
                    }
                    if (getElements()[getCurrentIndex()] > 0) {
                        int currentValue = getElements()[getCurrentIndex()];
                        getElements()[getCurrentIndex()] -= 1;
                        setCurrentIndex(getCurrentIndex() + 1);
                        currentLimit++;
                        return currentValue;
                    }
                    if (getElements()[getCurrentIndex()] == 0) {
                        setCurrentIndex(getCurrentIndex() + 1);
                    }
                }
                return -1;
            }
        };
    }
}