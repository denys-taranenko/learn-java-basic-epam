package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance;

import java.math.BigInteger;
import java.time.Period;

public record RepeatablePayment(Period unit, Currency currency, BigInteger amount) {

}
