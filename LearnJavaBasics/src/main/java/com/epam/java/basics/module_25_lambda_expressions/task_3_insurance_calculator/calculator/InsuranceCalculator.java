package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.Subject;

import java.util.Optional;

@FunctionalInterface
public interface InsuranceCalculator<S extends Subject> {

    Optional<InsuranceCoefficient> calculate(S entity);
}
