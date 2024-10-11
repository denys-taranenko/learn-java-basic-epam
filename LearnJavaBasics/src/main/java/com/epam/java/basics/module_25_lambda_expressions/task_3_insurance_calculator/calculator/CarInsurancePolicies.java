package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Car;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public final class CarInsurancePolicies {

    private CarInsurancePolicies() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static InsuranceCalculator<Car> ageDependInsurance(LocalDate baseDate) {
        return entity -> Optional.ofNullable(entity)
                .map(Car::manufactureDate)
                .map(manufactureDate -> Period.between(manufactureDate, baseDate))
                .flatMap(CarInsurancePolicies::determineCoefficient);
    }


    private static Optional<InsuranceCoefficient> determineCoefficient(Period difference) {
        return checkCondition(difference, 1, InsuranceCoefficient.MAX)
                .or(() -> checkCondition(difference, 5, InsuranceCoefficient.of(70)))
                .or(() -> checkCondition(difference, 10, InsuranceCoefficient.of(30)))
                .or(() -> Optional.of(InsuranceCoefficient.MIN));
    }

    private static Optional<InsuranceCoefficient> checkCondition(Period difference, int years,
                                                                 InsuranceCoefficient coefficient) {
        return Optional.of(difference)
                .filter(diff ->
                        diff.getYears() < years
                                || (diff.getYears() == years
                                && diff.getMonths() == 0
                                && diff.getDays() == 0))
                .map(diff -> coefficient);
    }

    public static InsuranceCalculator<Car> priceAndOwningOfFreshCarInsurance(LocalDate baseDate,
                                                                             BigInteger priceThreshold,
                                                                             Period owningThreshold) {
        return entity -> Optional.ofNullable(entity)
                .filter(e -> e.soldDate().isEmpty())
                .filter(e -> e.price() != null)
                .filter(e -> e.price().compareTo(priceThreshold) >= 0)
                .map(e -> e.purchaseDate().plus(owningThreshold))
                .filter(localDate -> !localDate.isBefore(baseDate))
                .map(localDate -> calculateInsuranceCoefficient(entity.price(), priceThreshold));
    }

    private static InsuranceCoefficient calculateInsuranceCoefficient(BigInteger price, BigInteger priceThreshold) {
        BigInteger firstCondition = priceThreshold.multiply(BigInteger.valueOf(3));
        BigInteger secondCondition = priceThreshold.multiply(BigInteger.valueOf(2));

        if (price.compareTo(firstCondition) >= 0) {
            return InsuranceCoefficient.MAX;
        } else if (price.compareTo(secondCondition) >= 0) {
            return InsuranceCoefficient.of(50);
        } else {
            return InsuranceCoefficient.MIN;
        }
    }
}
