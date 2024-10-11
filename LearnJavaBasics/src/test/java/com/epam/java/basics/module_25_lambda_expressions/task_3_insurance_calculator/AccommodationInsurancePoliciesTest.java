package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator;

import java.math.BigInteger;
import java.time.Period;
import java.util.stream.Stream;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.AccommodationInsurancePolicies;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCalculator;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCoefficient;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Accommodation;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Currency;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.RepeatablePayment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AccommodationInsurancePoliciesTest implements InsuranceCalculatorTest<Accommodation> {

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for rent dependent accommodation insurance")
    @MethodSource
    public void testRentDependentInsurance(InsuranceCalculator<Accommodation> calculator, Accommodation subject,
                                           InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testRentDependentInsurance() {
        return InsuranceCalculatorTest.buildFor(
                       AccommodationInsurancePolicies.rentDependentInsurance(BigInteger.valueOf(10_000L)),
                        Accommodation::new)
                .addNull(null)
                .add(InsuranceCalculatorTest.emptyConf(), null)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofDays(10), Currency.USD, BigInteger.valueOf(500L))), null)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.AUD, BigInteger.valueOf(1000L))), null)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.EUR, BigInteger.valueOf(10_000L))),
                        null)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.USD, BigInteger.valueOf(10_000L))),
                        InsuranceCoefficient.MAX)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.USD, BigInteger.valueOf(100_000L))),
                        InsuranceCoefficient.MAX)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.USD, BigInteger.valueOf(5_000L))),
                        InsuranceCoefficient.MED)
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.USD, BigInteger.valueOf(7_500L))),
                        InsuranceCoefficient.of(75))
                .add(acc -> acc.rent(new RepeatablePayment(Period.ofMonths(1), Currency.USD, BigInteger.valueOf(0))), null)
                .build();
    }

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for price, rooms & area dependent accommodation insurance")
    @MethodSource
    public void testPriceAndRoomsAndAreaDependentInsurance(InsuranceCalculator<Accommodation> calculator,
                                                           Accommodation subject, InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testPriceAndRoomsAndAreaDependentInsurance() {
        return InsuranceCalculatorTest.buildFor(
                        AccommodationInsurancePolicies.priceAndRoomsAndAreaDependentInsurance(
                                BigInteger.valueOf(1_000_000L),
                                5,
                                BigInteger.valueOf(150L)
                        )
                        , Accommodation::new)
                .addNull(InsuranceCoefficient.MIN)
                .add(InsuranceCalculatorTest.emptyConf(), InsuranceCoefficient.MIN)
                .add(acc -> acc.price(BigInteger.valueOf(500_000L)), InsuranceCoefficient.MIN)
                .add(acc -> acc.price(BigInteger.valueOf(1_000_000L)).rooms(4), InsuranceCoefficient.MIN)
                .add(acc -> acc.price(BigInteger.valueOf(1_000_000L)).rooms(5).area(BigInteger.valueOf(50L)),
                        InsuranceCoefficient.MIN)
                .add(acc -> acc.price(BigInteger.valueOf(1_000_000L)).rooms(5).area(BigInteger.valueOf(150)),
                        InsuranceCoefficient.MAX)
                .build();
    }
}
