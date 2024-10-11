package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.CarInsurancePolicies;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCalculator;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCoefficient;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarInsuranceCalculatorTest implements InsuranceCalculatorTest<Car> {

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for car insurance age dependent car")
    @MethodSource
    public void testAgeDependentCar(InsuranceCalculator<Car> calculator, Car subject,
                                    InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testAgeDependentCar() {
        var baseDate = LocalDate.of(2023, Month.JANUARY, 1);
        return InsuranceCalculatorTest.buildFor(CarInsurancePolicies.ageDependInsurance(baseDate), Car::new)
                .addNull(null)
                .add(InsuranceCalculatorTest.emptyConf(), null)
                .add(car -> car.manufactureDate(baseDate.minusYears(1)), InsuranceCoefficient.MAX)
                .add(car -> car.manufactureDate(baseDate.minusMonths(6)), InsuranceCoefficient.MAX)
                .add(car -> car.manufactureDate(baseDate.minusYears(2)), InsuranceCoefficient.of(70))
                .add(car -> car.manufactureDate(baseDate.minusYears(3)), InsuranceCoefficient.of(70))
                .add(car -> car.manufactureDate(baseDate.minusYears(4)), InsuranceCoefficient.of(70))
                .add(car -> car.manufactureDate(baseDate.minusYears(5)), InsuranceCoefficient.of(70))
                .add(car -> car.manufactureDate(baseDate.minusYears(6)), InsuranceCoefficient.of(30))
                .add(car -> car.manufactureDate(baseDate.minusYears(7)), InsuranceCoefficient.of(30))
                .add(car -> car.manufactureDate(baseDate.minusYears(8)), InsuranceCoefficient.of(30))
                .add(car -> car.manufactureDate(baseDate.minusYears(9)), InsuranceCoefficient.of(30))
                .add(car -> car.manufactureDate(baseDate.minusYears(10)), InsuranceCoefficient.of(30))
                .add(car -> car.manufactureDate(baseDate.minusYears(11)), InsuranceCoefficient.MIN)
                .build();
    }

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for car insurance for not sold cars which is depending on it's price, purchase date, freshness")
    @MethodSource
    public void testPriceAndOwningOfFreshCarInsurance(InsuranceCalculator<Car> calculator, Car subject,
                                                      InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testPriceAndOwningOfFreshCarInsurance() {
        var baseDate = LocalDate.of(2023, Month.JANUARY, 1);
        var priceThreshold = BigInteger.valueOf(100_000);
        var owningThreshold = Period.ofYears(3);
        return InsuranceCalculatorTest.buildFor(
                        CarInsurancePolicies.priceAndOwningOfFreshCarInsurance(baseDate, priceThreshold, owningThreshold), Car::new)
                .addNull(null)
                .add(InsuranceCalculatorTest.emptyConf(), null)
                .add(car -> car.soldDate(LocalDate.MIN), null)
                .add(car -> car.price(priceThreshold.divide(BigInteger.TWO)), null)
                .add(car -> car
                        .price(priceThreshold)
                        .purchaseDate(baseDate.minus(owningThreshold).minusDays(1)), null)
                .add(car -> car
                        .price(priceThreshold)
                        .purchaseDate(baseDate.minus(owningThreshold)), InsuranceCoefficient.MIN)
                .add(car -> car
                        .price(priceThreshold.multiply(BigInteger.TWO))
                        .purchaseDate(baseDate.minus(owningThreshold)), InsuranceCoefficient.MED)
                .add(car -> car
                        .price(priceThreshold.multiply(BigInteger.valueOf(3)))
                        .purchaseDate(baseDate.minus(owningThreshold)), InsuranceCoefficient.MAX)
                .add(car -> car
                        .soldDate(baseDate)
                        .price(priceThreshold)
                        .purchaseDate(baseDate.minus(owningThreshold)), null)
                .add(car -> car
                        .soldDate(baseDate)
                        .price(priceThreshold.multiply(BigInteger.TWO))
                        .purchaseDate(baseDate.minus(owningThreshold)), null)
                .add(car -> car
                        .soldDate(baseDate)
                        .price(priceThreshold.multiply(BigInteger.valueOf(3)))
                        .purchaseDate(baseDate.minus(owningThreshold)), null)
                .build();
    }
}
