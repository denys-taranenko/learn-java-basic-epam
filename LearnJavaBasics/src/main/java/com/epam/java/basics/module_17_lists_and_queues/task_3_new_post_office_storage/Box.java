package com.epam.java.basics.module_17_lists_and_queues.task_3_new_post_office_storage;

import java.math.BigDecimal;
import java.util.Objects;

public class Box implements Cloneable {
    private final String addresser;
    private final String recipient;
    private final double weight;
    private final double volume;
    private BigDecimal cost;
    private String city;
    private int officeNumber;

    public Box(String addresser, String recipient,
               double weight, double volume, BigDecimal cost,
               String city, int officeNumber) {
        this.addresser = addresser;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.city = city;
        this.officeNumber = officeNumber;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Double.compare(box.weight, weight) == 0 &&
                Double.compare(box.volume, volume) == 0 &&
                officeNumber == box.officeNumber &&
                Objects.equals(addresser, box.addresser) &&
                Objects.equals(recipient, box.recipient) &&
                Objects.equals(cost, box.cost) &&
                Objects.equals(city, box.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresser, recipient, weight, volume, cost, city, officeNumber);
    }

    @Override
    public String toString() {
        return "Box{" +
                "officeNumber=" + officeNumber +
                ", city='" + city + '\'' +
                ", addresser='" + addresser + '\'' +
                ", recipient='" + recipient + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", cost=" + cost +
                '}';
    }

    @Override
    public Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}
