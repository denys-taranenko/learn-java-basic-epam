package com.epam.java.basics.module_8_nested_classes.task_2_arithmetic_expressions;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {

        return new Expression() {

            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value < 0) {
                    return "(" + value + ")";
                } else {
                    return String.valueOf(value);
                }
            }
        };
    }

    public static Expression sum(Expression... members){

        return new Expression() {

            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression member : members) {
                    sum += member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < members.length; i++) {
                    result.append(members[i].toExpressionString());
                    if (i < members.length - 1) {
                        result.append(" + ");
                    }
                }
                return "(" + result + ")";
            }
        };
    }

    public static Expression product(Expression... members){

        return new Expression() {

            @Override
            public int evaluate() {
                int multiply = 1;
                for (Expression member : members) {
                    multiply *= member.evaluate();
                }
                return multiply;
            }

            @Override
            public String toExpressionString() {
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < members.length; i++) {
                    result.append(members[i].toExpressionString());
                    if (i < members.length - 1) {
                        result.append(" * ");
                    }
                }
                return "(" + result + ")";
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){

        return new Expression() {

            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){

        return new Expression() {

            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
    }
}