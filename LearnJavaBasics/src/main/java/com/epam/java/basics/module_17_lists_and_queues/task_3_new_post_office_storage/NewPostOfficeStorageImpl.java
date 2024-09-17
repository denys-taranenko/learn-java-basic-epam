package com.epam.java.basics.module_17_lists_and_queues.task_3_new_post_office_storage;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {
    private final List<Box> parcels;

    /**
     * Creates internal storage for becoming parcels
     */
    public NewPostOfficeStorageImpl() {
        parcels = new LinkedList<>();
    }

    /**
     * Creates own storage and appends all parcels into own storage.
     * It must add either all the parcels or nothing, if an exception occurs.
     *
     * @param boxes a collection of parcels.
     * @throws NullPointerException if the parameter is {@code null}
     *                              or contains {@code null} values.
     */
    public NewPostOfficeStorageImpl(Collection<Box> boxes) {
        isNullThisElement(boxes);
        isNullThisCollectionElements(boxes);

        parcels = new LinkedList<>(boxes);
    }

    @Override
    public boolean acceptBox(Box box) {
        isNullThisElement(box);

        parcels.add(box);
        return true;
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        isNullThisElement(boxes);
        isNullThisCollectionElements(boxes);

        List<Box> tempStorage = new LinkedList<>(boxes);

        parcels.addAll(tempStorage);
        return true;
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        isNullThisElement(boxes);
        isNullThisCollectionElements(boxes);

        int parcelsSize = parcels.size();
        parcels.removeAll(boxes);
        return parcelsSize != parcels.size();
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        isNullThisElement(predicate);

        List<Box> tempStorage = new LinkedList<>();

        Iterator<Box> iterator = parcels.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (predicate.test(box)) {
                tempStorage.add(box);
                iterator.remove();
            }
        }

        return tempStorage;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException();
        }

        return searchBoxes(new Predicate<>() {
            @Override
            public boolean test(Box box) {
                return box.getWeight() < weight;
            }
        });
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        isNullThisElement(cost);
        if (cost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        return searchBoxes(new Predicate<>() {
            @Override
            public boolean test(Box box) {
                return box.getCost().compareTo(cost) > 0;
            }
        });
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        if (volume < 0) {
            throw new IllegalArgumentException();
        }

        return searchBoxes(new Predicate<>() {
            @Override
            public boolean test(Box box) {
                return box.getVolume() >= volume;
            }
        });
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        isNullThisElement(predicate);

        List<Box> tempStorage = new LinkedList<>();

        Iterator<Box> iterator = parcels.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (predicate.test(box)) {
                tempStorage.add(box);
            }
        }
        return tempStorage;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        isNullThisElement(predicate);
        if (newOfficeNumber <= 0) {
            throw new IllegalArgumentException();
        }

        Iterator<Box> iterator = parcels.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (predicate.test(box)) {
                box.setOfficeNumber(newOfficeNumber);
            }
        }
    }

    private void isNullThisElement(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }

    private void isNullThisCollectionElements(Collection<Box> boxes) {
        Iterator<Box> iterator = boxes.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box == null) {
                throw new NullPointerException();
            }
        }
    }
}
