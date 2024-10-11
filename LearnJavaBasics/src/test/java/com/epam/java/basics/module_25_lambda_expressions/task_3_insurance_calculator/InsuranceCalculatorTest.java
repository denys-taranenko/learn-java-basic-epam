package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCalculator;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCoefficient;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Subject;
import org.junit.jupiter.params.provider.Arguments;

interface InsuranceCalculatorTest<S extends Subject> {

    @SuppressWarnings("all")
    default void testSubject(InsuranceCalculator<S> calculator, S subject, InsuranceCoefficient expectedInsurance) {
        var actualInsurance = calculator.calculate(subject);
        if (actualInsurance.isEmpty() && expectedInsurance != null) {
            fail("Expected " + expectedInsurance + " for " + subject + ", but was empty");
        }
        if (actualInsurance.isPresent() && expectedInsurance == null) {
            fail("Expected nothing for " + subject + ", but was " + actualInsurance.get());
        }
        if (actualInsurance.isEmpty()) {
            return;
        }
        assertEquals(expectedInsurance, actualInsurance.get(),
                () -> "For subject " + subject + " expected " + expectedInsurance + " insurance, but was " + actualInsurance.get());
    }

    static <S extends Subject> TestCases<S> buildFor(InsuranceCalculator<S> calculator, Supplier<S> generator) {
        return new TestCases<>(calculator, generator);
    }
    static <T> Consumer<T> emptyConf() {
        return __ -> {};
    }

    class TestCases<S extends Subject> {

        private final InsuranceCalculator<S> calculator;
        private final Supplier<S> generator;
        private final List<Pair<S, InsuranceCoefficient>> cases = new ArrayList<>();

        public TestCases(InsuranceCalculator<S> calculator, Supplier<S> generator) {
            this.calculator = calculator;
            this.generator = generator;
        }

        TestCases<S> addNull(InsuranceCoefficient expectedInsurance) {
            return add((S) null, expectedInsurance);
        }

        TestCases<S> add(Consumer<S> configurer, InsuranceCoefficient expectedInsurance) {
            var subject = generator.get();
            configurer.accept(subject);
            return add(subject, expectedInsurance);
        }

        TestCases<S> add(S subject, InsuranceCoefficient expectedInsurance) {
            cases.add(new Pair<>(subject, expectedInsurance));
            return this;
        }

        Stream<Arguments> build() {
            return cases.stream()
                    .map(e -> Arguments.arguments(calculator, e.first(), e.second()));
        }
    }

    record Pair<F, S>(F first, S second) {}
}
