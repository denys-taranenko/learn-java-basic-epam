package com.epam.java.basics.module_25_lambda_expressions.task_1_throwing_function_task;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Throwable> {
    R apply(T t) throws E;

    static <T, R, E extends Throwable>Function<T, R> quiet(ThrowingFunction<T, R, E> throwingFunction) {
        if (throwingFunction == null) {
            return null;
        }
        return t -> {
            try {
                return throwingFunction.apply(t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
