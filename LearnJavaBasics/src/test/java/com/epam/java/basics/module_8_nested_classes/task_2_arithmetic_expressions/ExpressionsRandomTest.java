package com.epam.java.basics.module_8_nested_classes.task_2_arithmetic_expressions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static com.epam.java.basics.module_8_nested_classes.task_2_arithmetic_expressions.Expressions.val;
import static com.epam.java.basics.module_8_nested_classes.task_2_arithmetic_expressions.Expressions.var;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExpressionsRandomTest {

    @ParameterizedTest(name = "[{index}] {0} {2}")
    @MethodSource("randomCases")
    void testRandomCases(int ignoredSeed,
                         Expression expression,
                         String expectedExpressionString,
                         int expectedEvaluationResult) {
        assertAll(
                () -> assertEquals(expectedExpressionString, expression.toExpressionString()),
                () -> assertEquals(expectedEvaluationResult, expression.evaluate())
        );
    }

    public static Stream<Arguments> randomCases() {
        Random random = new Random(23158546);

        return random.ints(10, 1, 1000000)
                .mapToObj(i -> {
                    Expression expression = randomExpression(i);
                    return arguments(
                            i,
                            expression,
                            readExpected("expression", i),
                            Integer.parseInt(readExpected("evaluation", i)));
                });
    }

    private static Expression randomExpression(int seed) {
        Random random = new Random(seed);
        int depthToGenerate = 3 + random.nextInt(3);

        Expression expression = randomVal(random);
        while (depthToGenerate != 0) {
            expression = randomBinaryExpression(random, expression);
            depthToGenerate--;
        }

        return expression;
    }

    private static Expression randomBinaryExpression(final Random random, final Expression expression) {
        BinaryOperator<Expression> op;
        if (random.nextBoolean()) {
            if (random.nextBoolean()) {
                op = Expressions::sum;
            } else {
                op = Expressions::product;
            }
        } else {
            if (random.nextBoolean()) {
                op = Expressions::difference;
            } else {
                op = Expressions::fraction;
            }
        }
        return random.nextBoolean() ?
                op.apply(expression, randomVarOrVal(random)) :
                op.apply(randomVarOrVal(random), expression);
    }

    private static Expression randomVarOrVal(final Random random) {
        return random.nextBoolean() ? randomVal(random) : randomVar(random);
    }

    private static Expression randomVal(final Random random) {
        return val(1 + random.nextInt(100));
    }

    private static Expression randomVar(final Random random) {
        return var("x" + random.nextInt(100), 1 + random.nextInt(100));
    }

    private static String readExpected(String collection, int seed) {
        try {
            return Files.readString(
                    Path.of("src", "test", "resources", collection, seed + ".txt"));

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}