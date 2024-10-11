package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public final class Accommodation implements Comparable<Accommodation>, Subject {

    private static final Comparator<Accommodation> CMP = Comparator.comparing(Accommodation::area);

    private String name;
    private Type type;
    private BigInteger price;
    private RepeatablePayment rent;
    private BigInteger area;
    private Integer rooms;
    private LocalDate constructionDate;
    private EmergencyStatus emergencyStatus;

    public Accommodation() {
    }

    public Optional<RepeatablePayment> rent() {
        return Optional.ofNullable(rent);
    }

    public Optional<EmergencyStatus> emergencyStatus() {
        return Optional.ofNullable(emergencyStatus);
    }

    @Override
    public int compareTo(Accommodation o) {
        return CMP.compare(this, o);
    }

    public String name() {
        return this.name;
    }

    public Type type() {
        return this.type;
    }

    public BigInteger price() {
        return this.price;
    }

    public BigInteger area() {
        return this.area;
    }

    public Integer rooms() {
        return this.rooms;
    }

    public LocalDate constructionDate() {
        return this.constructionDate;
    }

    public Accommodation name(String name) {
        this.name = name;
        return this;
    }

    public Accommodation type(Type type) {
        this.type = type;
        return this;
    }

    public Accommodation price(BigInteger price) {
        this.price = price;
        return this;
    }

    public Accommodation rent(RepeatablePayment rent) {
        this.rent = rent;
        return this;
    }

    public Accommodation area(BigInteger area) {
        this.area = area;
        return this;
    }

    public Accommodation rooms(Integer rooms) {
        this.rooms = rooms;
        return this;
    }

    public Accommodation constructionDate(LocalDate constructionDate) {
        this.constructionDate = constructionDate;
        return this;
    }

    public Accommodation emergencyStatus(EmergencyStatus emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Accommodation other)) {
            return false;
        }
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (!Objects.equals(this$name, other$name)) {
            return false;
        }
        final Object this$type = this.type;
        final Object other$type = other.type;
        if (!Objects.equals(this$type, other$type)) {
            return false;
        }
        final Object this$price = this.price;
        final Object other$price = other.price;
        if (!Objects.equals(this$price, other$price)) {
            return false;
        }
        final Object this$rent = this.rent;
        final Object other$rent = other.rent;
        if (!Objects.equals(this$rent, other$rent)) {
            return false;
        }
        final Object this$area = this.area;
        final Object other$area = other.area;
        if (!Objects.equals(this$area, other$area)) {
            return false;
        }
        final Object this$rooms = this.rooms;
        final Object other$rooms = other.rooms;
        if (!Objects.equals(this$rooms, other$rooms)) {
            return false;
        }
        final Object this$constructionDate = this.constructionDate;
        final Object other$constructionDate = other.constructionDate;
        if (!Objects.equals(this$constructionDate, other$constructionDate)) {
            return false;
        }
        final Object this$emergencyStatus = this.emergencyStatus;
        final Object other$emergencyStatus = other.emergencyStatus;
        return Objects.equals(this$emergencyStatus, other$emergencyStatus);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $type = this.type;
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $price = this.price;
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $rent = this.rent;
        result = result * PRIME + ($rent == null ? 43 : $rent.hashCode());
        final Object $area = this.area;
        result = result * PRIME + ($area == null ? 43 : $area.hashCode());
        final Object $rooms = this.rooms;
        result = result * PRIME + ($rooms == null ? 43 : $rooms.hashCode());
        final Object $constructionDate = this.constructionDate;
        result = result * PRIME + ($constructionDate == null ? 43 : $constructionDate.hashCode());
        final Object $emergencyStatus = this.emergencyStatus;
        result = result * PRIME + ($emergencyStatus == null ? 43 : $emergencyStatus.hashCode());
        return result;
    }

    public String toString() {
        return "Accommodation(name=" + this.name + ", type=" + this.type + ", price=" + this.price + ", rent=" + this.rent
                + ", area=" + this.area + ", rooms=" + this.rooms + ", constructionDate=" + this.constructionDate
                + ", emergencyStatus=" + this.emergencyStatus + ")";
    }

    public enum Type {
        HOUSE,
        APARTMENT,
        ROOM,
        GARAGE,
        OFFICE,
        WAREHOUSE
    }

    public enum EmergencyStatus {
        NONE,
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }
}
