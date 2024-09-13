package com.epam.java.basics.module_16_introduction_to_collections.task_1_iterating_collections;

import java.math.BigDecimal;
import java.util.Objects;

public class Box implements Cloneable {
    private final String addresser;
    private final String recipient;
    private final double weight;
    private final double volume;
    private BigDecimal cost;

    public Box(String addresser, String recipient, double weight, double volume) {
        this.addresser = addresser;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
    }

    public String getAddresser() {
        return addresser;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "addresser=" + addresser +
                ", recipient=" + recipient +
                ", weight=" + weight +
                ", volume=" + volume +
                ", costBox=" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Double.compare(box.weight, weight) == 0
                && Double.compare(box.volume, volume) == 0
                && addresser.equals(box.addresser)
                && recipient.equals(box.recipient)
                && Objects.equals(cost, box.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresser, recipient, weight, volume, cost);
    }

    @Override
    public Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}