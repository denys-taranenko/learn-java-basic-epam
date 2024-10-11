package com.epam.java.basics.module_25_lambda_expressions.task_2_percentage_formatter_task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.function.DoubleFunction;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("PercentageFormatter correctness test")
public class PercentageFormatterTest {

    @DisplayName("Tests PercentageFormatter is a lambda")
    @Test
    @SuppressWarnings("rawtypes")
    void shouldBeImplementedViaLambda() {
        Class<? extends DoubleFunction> iClass = PercentageFormatter.INSTANCE.getClass();
        if (!iClass.isSynthetic()) {
            fail("PercentageFormatter must be implemented as a lambda");
        }
    }

    @DisplayName("Tests that PercentageFormatter functionality is correct")
    @ParameterizedTest(name = "{0} must be transformed to \"{1}\"")
    @MethodSource
    void shouldReturnCorrectResult(double percent, String expected) {
        var actual = PercentageFormatter.INSTANCE.apply(percent);
        assertEquals(expected, actual, "Percentage formatter failed to process this case");
    }

    static Stream<Arguments> shouldReturnCorrectResult() {
        return Stream.of(
                testCase(0.5, "50 %"),
                testCase(-0.43, "-43 %"),
                testCase(0.6875, "68.8 %"),
                testCase(1.2, "120 %"),
                testCase(0.54333, "54.3 %")
        );
    }

    static Arguments testCase(double percent, String expected) {
        return arguments(percent, expected);
    }
}
