package com.epam.java.basics.module_16_introduction_to_collections.task_1_iterating_collections;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {
    private final Collection<Box> listBox;
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    public boolean addBox(String addresser, String recipient, double weight, double volume, int value) {
        if (addresser == null || addresser.trim().isEmpty() || recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (weight < 0.5 || weight > 20.0 || volume <= 0 || volume > 0.25 || value <= 0) {
                throw new IllegalArgumentException();
        }

        Box newBox = new Box(addresser, recipient, weight, volume);
        BigDecimal costNewBox = calculateCostOfBox(weight, volume, value);
        newBox.setCost(costNewBox);

        return listBox.add(newBox);
    }

    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        Collection<Box> recipientBox = new ArrayList<>();
        Iterator<Box> iterator = listBox.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box != null && box.getRecipient().equals(recipient)) {
                recipientBox.add(box);
                iterator.remove();
            }
        }
        return recipientBox;
    }

    public void declineCostOfBox(double percent) {
        if (percent < 0 || percent > 100) {
            throw  new IllegalArgumentException();
        }

        BigDecimal factor = BigDecimal.valueOf(1 - percent / 100);

        for (Box box : listBox) {
            if (box != null) {
                BigDecimal newCost = box.getCost().multiply(factor, MathContext.DECIMAL64);
                box.setCost(newCost);
            }
        }
    }
}