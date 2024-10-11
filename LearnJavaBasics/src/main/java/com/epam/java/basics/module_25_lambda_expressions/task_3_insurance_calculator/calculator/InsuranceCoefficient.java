package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator;

import java.math.BigInteger;

/**
 * Range is [0; 100].
 */
public record InsuranceCoefficient(int coefficient) {

    public static final InsuranceCoefficient MAX = new InsuranceCoefficient(100);
    public static final InsuranceCoefficient MED = new InsuranceCoefficient(50);
    public static final InsuranceCoefficient MIN = new InsuranceCoefficient(0);

    public InsuranceCoefficient {
        if (coefficient < 0 || coefficient > 100) {
            throw new IllegalArgumentException("Coefficient must be in range [0; 100], but was " + coefficient);
        }
    }

    public static InsuranceCoefficient of(int coefficient) {
        return new InsuranceCoefficient(coefficient);
    }

    public static InsuranceCoefficient of(BigInteger coefficient) {
        return new InsuranceCoefficient(coefficient.intValueExact());
    }
}
