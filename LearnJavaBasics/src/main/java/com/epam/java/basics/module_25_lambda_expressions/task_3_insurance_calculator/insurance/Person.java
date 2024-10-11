package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public final class Person implements Subject {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private Map<Currency, BigInteger> account;
    private Family family;
    private SortedSet<Employment> employmentHistory;
    private Set<Car> carOwningHistory;
    private SortedSet<Injury> injuries;
    private SortedSet<Accommodation> accommodations;

    public Person() {
    }

    public Optional<Family> family() {
        return Optional.ofNullable(family);
    }

    public String name() {
        return this.name;
    }

    public String surname() {
        return this.surname;
    }

    public LocalDate birthDate() {
        return this.birthDate;
    }

    public Map<Currency, BigInteger> account() {
        return this.account;
    }

    public SortedSet<Employment> employmentHistory() {
        return this.employmentHistory;
    }

    public Set<Car> carOwningHistory() {
        return this.carOwningHistory;
    }

    public SortedSet<Injury> injuries() {
        return this.injuries;
    }

    public SortedSet<Accommodation> accommodations() {
        return this.accommodations;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person surname(String surname) {
        this.surname = surname;
        return this;
    }

    public Person birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Person account(Map<Currency, BigInteger> account) {
        this.account = account;
        return this;
    }

    public Person family(Family family) {
        this.family = family;
        return this;
    }

    public Person employmentHistory(SortedSet<Employment> employmentHistory) {
        this.employmentHistory = employmentHistory;
        return this;
    }

    public Person carOwningHistory(Set<Car> carOwningHistory) {
        this.carOwningHistory = carOwningHistory;
        return this;
    }

    public Person injuries(SortedSet<Injury> injuries) {
        this.injuries = injuries;
        return this;
    }

    public Person accommodations(SortedSet<Accommodation> accommodations) {
        this.accommodations = accommodations;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person other)) {
            return false;
        }
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (!Objects.equals(this$name, other$name)) {
            return false;
        }
        final Object this$surname = this.surname;
        final Object other$surname = other.surname;
        if (!Objects.equals(this$surname, other$surname)) {
            return false;
        }
        final Object this$birthDate = this.birthDate;
        final Object other$birthDate = other.birthDate;
        if (!Objects.equals(this$birthDate, other$birthDate)) {
            return false;
        }
        final Object this$account = this.account;
        final Object other$account = other.account;
        if (!Objects.equals(this$account, other$account)) {
            return false;
        }
        final Object this$family = this.family;
        final Object other$family = other.family;
        if (!Objects.equals(this$family, other$family)) {
            return false;
        }
        final Object this$employmentHistory = this.employmentHistory;
        final Object other$employmentHistory = other.employmentHistory;
        if (!Objects.equals(this$employmentHistory, other$employmentHistory)) {
            return false;
        }
        final Object this$carOwningHistory = this.carOwningHistory;
        final Object other$carOwningHistory = other.carOwningHistory;
        if (!Objects.equals(this$carOwningHistory, other$carOwningHistory)) {
            return false;
        }
        final Object this$injuries = this.injuries;
        final Object other$injuries = other.injuries;
        if (!Objects.equals(this$injuries, other$injuries)) {
            return false;
        }
        final Object this$accommodations = this.accommodations;
        final Object other$accommodations = other.accommodations;
        return Objects.equals(this$accommodations, other$accommodations);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.surname;
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $birthDate = this.birthDate;
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        final Object $account = this.account;
        result = result * PRIME + ($account == null ? 43 : $account.hashCode());
        final Object $family = this.family;
        result = result * PRIME + ($family == null ? 43 : $family.hashCode());
        final Object $employmentHistory = this.employmentHistory;
        result = result * PRIME + ($employmentHistory == null ? 43 : $employmentHistory.hashCode());
        final Object $carOwningHistory = this.carOwningHistory;
        result = result * PRIME + ($carOwningHistory == null ? 43 : $carOwningHistory.hashCode());
        final Object $injuries = this.injuries;
        result = result * PRIME + ($injuries == null ? 43 : $injuries.hashCode());
        final Object $accommodations = this.accommodations;
        result = result * PRIME + ($accommodations == null ? 43 : $accommodations.hashCode());
        return result;
    }

    public String toString() {
        return "Person(name=" + this.name + ", surname=" + this.surname + ", birthDate=" + this.birthDate + ", account="
                + this.account + ", family=" + this.family + ", employmentHistory=" + this.employmentHistory
                + ", carOwningHistory=" + this.carOwningHistory + ", injuries=" + this.injuries + ", accommodations="
                + this.accommodations + ")";
    }
}
