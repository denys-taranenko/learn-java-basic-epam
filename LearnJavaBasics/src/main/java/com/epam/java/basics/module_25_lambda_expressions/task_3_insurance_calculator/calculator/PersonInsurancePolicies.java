package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Accommodation;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Currency;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Person;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public final class PersonInsurancePolicies {

    private PersonInsurancePolicies() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static InsuranceCalculator<Person> childrenDependent(int childrenCountThreshold) {
        return entity -> Optional.of(Optional.ofNullable(entity)
                .filter(e -> e.family().isPresent() && e.family().get().children() != null &&
                        !e.family().get().children().isEmpty())
                .map(e -> e.family().get().children().size())
                .map(childrenCount -> Math.min(100, (childrenCount * 100) / childrenCountThreshold))
                .map(InsuranceCoefficient::of)
                .orElse(InsuranceCoefficient.MIN));
    }

    public static InsuranceCalculator<Person> employmentDependentInsurance(BigInteger salaryThreshold,
                                                                           Set<Currency> currencies) {
        return entity -> Optional.ofNullable(entity)
                .filter(e -> e.employmentHistory() != null && e.employmentHistory().size() >= 4)
                .filter(e -> e.account() != null && !e.account().isEmpty())
                .filter(e -> e.injuries() == null || e.injuries().isEmpty())
                .filter(e -> e.accommodations() != null && !e.accommodations().isEmpty())
                .filter(e -> e.employmentHistory().last().endDate().isEmpty())
                .flatMap(e -> e.employmentHistory().last().salary())
                .filter(salary -> currencies.contains(salary.currency()))
                .filter(salary -> salary.amount().compareTo(salaryThreshold) >= 0)
                .map(salary -> InsuranceCoefficient.of(50));
    }

    public static InsuranceCalculator<Person> accommodationEmergencyInsurance(Set<Accommodation.EmergencyStatus> statuses) {
        return person -> {
            if (person == null || statuses == null || statuses.isEmpty()) {
                return Optional.empty();
            }

            Optional<Accommodation> accommodation = Optional.ofNullable(person.accommodations())
                    .flatMap(accommodations -> accommodations.stream()
                            .filter(ac -> ac.emergencyStatus().filter(statuses::contains).isPresent())
                            .min(Comparator.comparing(Accommodation::area)));

            if (accommodation.isEmpty()) {
                return Optional.empty();
            }

            Accommodation chosenAccommodation = accommodation.get();
            int statusOrdinal = chosenAccommodation.emergencyStatus()
                    .map(Accommodation.EmergencyStatus::ordinal)
                    .orElse(0);

            int totalStatuses = statuses.size();
            double coefficient = 100 * (1 - (double) statusOrdinal / (totalStatuses + 3));

            return Optional.of(InsuranceCoefficient.of((int)coefficient));
        };
    }


    public static InsuranceCalculator<Person> injuryAndRentDependentInsurance(BigInteger rentThreshold) {
        return entity -> Optional.ofNullable(entity)
                .filter(e -> e.injuries() != null && e.accommodations() != null)
                .flatMap(e -> e.injuries().stream()
                        .filter(i -> i.culprit().isPresent())
                        .findFirst())
                .flatMap(injury -> entity.accommodations().stream()
                        .filter(accommodation -> accommodation.rent().isPresent()
                                && accommodation.rent().get().currency().equals(Currency.GBP))
                        .max(Comparator.comparing(Accommodation::area))
                        .flatMap(accommodation -> Optional.of(accommodation.rent().get().amount())))
                .map(rent -> {
                    if (rent.signum() == 0) {
                        return InsuranceCoefficient.MIN;
                    }
                    BigInteger coefficient = rent.compareTo(rentThreshold) < 0
                            ? rent.multiply(BigInteger.valueOf(100)).divide(rentThreshold)
                            : BigInteger.valueOf(100);
                    return InsuranceCoefficient.of(coefficient);
                });
    }
}
