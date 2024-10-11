package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Accommodation;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Currency;

import java.math.BigInteger;
import java.util.Optional;
//import edu.epam.fop.lambdas.insurance.Accommodation;
//import edu.epam.fop.lambdas.insurance.Currency;
public final class AccommodationInsurancePolicies {

    private AccommodationInsurancePolicies() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static InsuranceCalculator<Accommodation> rentDependentInsurance(BigInteger divider) {
        return entity -> Optional.ofNullable(entity)
                .flatMap(Accommodation::rent)
                .filter(rent -> rent.unit().getMonths() > 0)
                .filter(rent -> rent.currency().equals(Currency.USD))
                .filter(rent -> rent.amount().intValue() > 0)
                .map(rent -> rent.amount().multiply(BigInteger.valueOf(100)).divide(divider))
                .map(coefficient -> coefficient.intValue() >= 100 ? InsuranceCoefficient.MAX : InsuranceCoefficient.of(coefficient));
    }

    public static InsuranceCalculator<Accommodation> priceAndRoomsAndAreaDependentInsurance(BigInteger priceThreshold,
                                                                                            int roomsThreshold,
                                                                                            BigInteger areaThreshold) {
        return entity -> Optional.of(Optional.ofNullable(entity)
                .flatMap(e -> Optional.ofNullable(e.price()))
                .filter(price -> price.compareTo(priceThreshold) >= 0)
                .flatMap(price -> Optional.ofNullable(entity.rooms()))
                .filter(rooms -> rooms >= roomsThreshold)
                .flatMap(rooms -> Optional.ofNullable(entity.area()))
                .filter(area -> area.compareTo(areaThreshold) >= 0)
                .map(ignored -> InsuranceCoefficient.MAX)
                .orElse(InsuranceCoefficient.MIN));
    }
}
