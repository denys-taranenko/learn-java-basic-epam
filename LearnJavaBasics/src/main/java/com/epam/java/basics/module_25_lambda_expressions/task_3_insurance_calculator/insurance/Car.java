package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance;


import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Car implements Subject {

    private String model;
    private BigInteger price;
    private LocalDate manufactureDate;
    private LocalDate purchaseDate;
    private LocalDate soldDate;

    public Car() {
    }

    public Optional<LocalDate> soldDate() {
        return Optional.ofNullable(soldDate);
    }

    public String model() {
        return this.model;
    }

    public BigInteger price() {
        return this.price;
    }

    public LocalDate manufactureDate() {
        return this.manufactureDate;
    }

    public LocalDate purchaseDate() {
        return this.purchaseDate;
    }

    public Car model(String model) {
        this.model = model;
        return this;
    }

    public Car price(BigInteger price) {
        this.price = price;
        return this;
    }

    public Car manufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
        return this;
    }

    public Car purchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public Car soldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Car other)) {
            return false;
        }
        final Object this$model = this.model;
        final Object other$model = other.model;
        if (!Objects.equals(this$model, other$model)) {
            return false;
        }
        final Object this$price = this.price;
        final Object other$price = other.price;
        if (!Objects.equals(this$price, other$price)) {
            return false;
        }
        final Object this$manufactureDate = this.manufactureDate;
        final Object other$manufactureDate = other.manufactureDate;
        if (!Objects.equals(this$manufactureDate, other$manufactureDate)) {
            return false;
        }
        final Object this$purchaseDate = this.purchaseDate;
        final Object other$purchaseDate = other.purchaseDate;
        if (!Objects.equals(this$purchaseDate, other$purchaseDate)) {
            return false;
        }
        final Object this$soldDate = this.soldDate;
        final Object other$soldDate = other.soldDate;
        return Objects.equals(this$soldDate, other$soldDate);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $model = this.model;
        result = result * PRIME + ($model == null ? 43 : $model.hashCode());
        final Object $price = this.price;
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $manufactureDate = this.manufactureDate;
        result = result * PRIME + ($manufactureDate == null ? 43 : $manufactureDate.hashCode());
        final Object $purchaseDate = this.purchaseDate;
        result = result * PRIME + ($purchaseDate == null ? 43 : $purchaseDate.hashCode());
        final Object $soldDate = this.soldDate;
        result = result * PRIME + ($soldDate == null ? 43 : $soldDate.hashCode());
        return result;
    }

    public String toString() {
        return "Car(model=" + this.model + ", price=" + this.price + ", manufactureDate=" + this.manufactureDate
                + ", purchaseDate=" + this.purchaseDate + ", soldDate=" + this.soldDate + ")";
    }

    public static class Incident implements Comparable<Incident> {

        private static final Comparator<Incident> CMP = Comparator.comparing(Incident::date);

        private LocalDate date;
        private BigInteger ownDamageCost;
        private List<BigInteger> othersDamageCosts;
        private Person culprit;

        public Incident() {
        }

        public Optional<Person> culprit() {
            return Optional.ofNullable(culprit);
        }

        @Override
        public int compareTo(Incident o) {
            return CMP.compare(this, o);
        }

        public LocalDate date() {
            return this.date;
        }

        public BigInteger ownDamageCost() {
            return this.ownDamageCost;
        }

        public List<BigInteger> othersDamageCosts() {
            return this.othersDamageCosts;
        }

        public Incident date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Incident ownDamageCost(BigInteger ownDamageCost) {
            this.ownDamageCost = ownDamageCost;
            return this;
        }

        public Incident othersDamageCosts(List<BigInteger> othersDamageCosts) {
            this.othersDamageCosts = othersDamageCosts;
            return this;
        }

        public Incident culprit(Person culprit) {
            this.culprit = culprit;
            return this;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Incident other)) {
                return false;
            }
            if (!other.canEqual(this)) {
                return false;
            }
            final Object this$date = this.date;
            final Object other$date = other.date;
            if (!Objects.equals(this$date, other$date)) {
                return false;
            }
            final Object this$ownDamageCost = this.ownDamageCost;
            final Object other$ownDamageCost = other.ownDamageCost;
            if (!Objects.equals(this$ownDamageCost, other$ownDamageCost)) {
                return false;
            }
            final Object this$othersDamageCosts = this.othersDamageCosts;
            final Object other$othersDamageCosts = other.othersDamageCosts;
            if (!Objects.equals(this$othersDamageCosts, other$othersDamageCosts)) {
                return false;
            }
            final Object this$culprit = this.culprit;
            final Object other$culprit = other.culprit;
            return Objects.equals(this$culprit, other$culprit);
        }

        protected boolean canEqual(final Object other) {
            return other instanceof Incident;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $date = this.date;
            result = result * PRIME + ($date == null ? 43 : $date.hashCode());
            final Object $ownDamageCost = this.ownDamageCost;
            result = result * PRIME + ($ownDamageCost == null ? 43 : $ownDamageCost.hashCode());
            final Object $othersDamageCosts = this.othersDamageCosts;
            result = result * PRIME + ($othersDamageCosts == null ? 43 : $othersDamageCosts.hashCode());
            final Object $culprit = this.culprit;
            result = result * PRIME + ($culprit == null ? 43 : $culprit.hashCode());
            return result;
        }

        public String toString() {
            return "Car.Incident(date=" + this.date + ", ownDamageCost=" + this.ownDamageCost + ", othersDamageCosts="
                    + this.othersDamageCosts + ", culprit=" + this.culprit + ")";
        }
    }
}
