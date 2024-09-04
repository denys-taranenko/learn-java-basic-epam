package com.epam.java.basics.module8.task2;

import org.junit.jupiter.api.Test;

import static com.epam.java.basics.module8.task2.Expressions.*;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionsTest {

    @Test
    void testRegularPositiveCase() {
        Expression expression = fraction(
                product(
                        var("a", 5),
                        sum(
                                val(8),
                                var("b", 22)
                        )
                ),
                difference(
                        val(100),
                        var("c", 98)
                )
        );

        assertAll(
                () -> assertEquals("((a * (8 + b)) / (100 - c))", expression.toExpressionString()),
                () -> assertEquals(75, expression.evaluate())
        );
    }

    @Test
    void testRegularPositiveCaseChangeVars() {
        Variable a = var("a", 5);
        Variable b = var("b", 22);
        Variable c = var("c", 98);

        Expression expression = fraction(
                product(
                        a,
                        sum(
                                val(8),
                                b
                        )
                ),
                difference(
                        val(100),
                        c
                )
        );

        assertAll(
                () -> assertEquals("((a * (8 + b)) / (100 - c))", expression.toExpressionString()),
                () -> assertEquals(75, expression.evaluate())
        );

        a.setValue(4);
        b.setValue(-2);
        c.setValue(88);

        assertAll(
                () -> assertEquals("((a * (8 + b)) / (100 - c))", expression.toExpressionString()),
                () -> assertEquals(2, expression.evaluate())
        );
    }

    @Test
    void testVal() {
        Expression val;

        val = val(789);

        assertEquals(789, val.evaluate());
        assertEquals("789", val.toExpressionString());

        val = val(-951);

        assertEquals(-951, val.evaluate());
        assertEquals("(-951)", val.toExpressionString());
    }

    @Test
    void testSimpleSum() {
        Expression sum;

        sum = sum(var("a", 7), val(9));

        assertEquals("(a + 9)", sum.toExpressionString());
        assertEquals(16, sum.evaluate());

        sum = sum(var("a", -7), val(-2), var("alpha", 789));

        assertEquals("(a + (-2) + alpha)", sum.toExpressionString());
        assertEquals(780, sum.evaluate());

        sum = sum(val(1), val(2), val(3), val(4), val(5), val(6));

        assertEquals("(1 + 2 + 3 + 4 + 5 + 6)", sum.toExpressionString());
        assertEquals(21, sum.evaluate());

        Variable x1 = var("x1", 7);
        Variable x2 = var("x2", 7);
        Variable x3 = var("x3", 7);
        sum = sum(x1, x2, x3);

        assertEquals("(x1 + x2 + x3)", sum.toExpressionString());
        assertEquals(21, sum.evaluate());

        x1.setValue(159);
        x2.setValue(753);
        x3.setValue(-1000);

        assertEquals("(x1 + x2 + x3)", sum.toExpressionString());
        assertEquals(-88, sum.evaluate());
    }

    @Test
    void testSimpleProduct() {
        Expression prod;

        prod = product(var("a", 7), val(9));

        assertEquals("(a * 9)", prod.toExpressionString());
        assertEquals(63, prod.evaluate());

        prod = product(var("a", -7), val(-2), var("alpha", 789));

        assertEquals("(a * (-2) * alpha)", prod.toExpressionString());
        assertEquals(11046, prod.evaluate());

        prod = product(val(1), val(2), val(3), val(4), val(5), val(6));

        assertEquals("(1 * 2 * 3 * 4 * 5 * 6)", prod.toExpressionString());
        assertEquals(720, prod.evaluate());

        Variable x1 = var("x1", 7);
        Variable x2 = var("x2", 7);
        Variable x3 = var("x3", 7);
        prod = product(x1, x2, x3);

        assertEquals("(x1 * x2 * x3)", prod.toExpressionString());
        assertEquals(343, prod.evaluate());

        x1.setValue(159);
        x2.setValue(753);
        x3.setValue(-1000);

        assertEquals("(x1 * x2 * x3)", prod.toExpressionString());
        assertEquals(-119_727_000, prod.evaluate());
    }

    @Test
    void testSimpleDifference() {
        Expression diff;

        diff = difference(var("a", 72), val(9));

        assertEquals("(a - 9)", diff.toExpressionString());
        assertEquals(63, diff.evaluate());

        diff = difference(var("a", -77), val(-11));

        assertEquals("(a - (-11))", diff.toExpressionString());
        assertEquals(-66, diff.evaluate());

        Variable x1 = var("x1", 7);
        Variable x2 = var("x2", 7);
        diff = difference(x1, x2);

        assertEquals("(x1 - x2)", diff.toExpressionString());
        assertEquals(0, diff.evaluate());

        x1.setValue(343);
        x2.setValue(-7);

        assertEquals("(x1 - x2)", diff.toExpressionString());
        assertEquals(350, diff.evaluate());
    }

    @Test
    void testSimpleFraction() {
        Expression fraction;

        fraction = fraction(var("a", 72), val(9));

        assertEquals("(a / 9)", fraction.toExpressionString());
        assertEquals(8, fraction.evaluate());

        fraction = fraction(var("a", -77), val(-11));

        assertEquals("(a / (-11))", fraction.toExpressionString());
        assertEquals(7, fraction.evaluate());

        Variable x1 = var("x1", 7);
        Variable x2 = var("x2", 7);
        fraction = fraction(x1, x2);

        assertEquals("(x1 / x2)", fraction.toExpressionString());
        assertEquals(1, fraction.evaluate());

        x1.setValue(343);
        x2.setValue(-7);

        assertEquals("(x1 / x2)", fraction.toExpressionString());
        assertEquals(-49, fraction.evaluate());
    }

    @Test
    void testDeepSum() {
        Expression expression =
                sum(
                        val(1),
                        sum(
                                val(2),
                                sum(
                                        val(3),
                                        sum(
                                                val(4),
                                                val(5)
                                        )
                                )
                        )
                );

        assertEquals("(1 + (2 + (3 + (4 + 5))))", expression.toExpressionString());
        assertEquals(15, expression.evaluate());
    }

    @Test
    void testDeepProduct() {
        Expression expression =
                product(
                        val(1),
                        product(
                                val(2),
                                product(
                                        val(3),
                                        product(
                                                val(4),
                                                val(5)
                                        )
                                )
                        )
                );

        assertEquals("(1 * (2 * (3 * (4 * 5))))", expression.toExpressionString());
        assertEquals(120, expression.evaluate());
    }

    @Test
    void testDeepFraction() {
        Expression expression =
                fraction(
                        val(999_999),
                        fraction(
                                val(81),
                                fraction(
                                        val(27),
                                        fraction(
                                                val(9),
                                                val(3)
                                        )
                                )
                        )
                );

        assertEquals("(999999 / (81 / (27 / (9 / 3))))", expression.toExpressionString());
        assertEquals(111_111, expression.evaluate());
    }

    @Test
    void testDeepDifference() {
        Expression expression =
                difference(
                        val(999_999),
                        difference(
                                val(81),
                                difference(
                                        val(27),
                                        difference(
                                                val(9),
                                                val(3)
                                        )
                                )
                        )
                );

        assertEquals("(999999 - (81 - (27 - (9 - 3))))", expression.toExpressionString());
        assertEquals(999_939, expression.evaluate());
    }
}