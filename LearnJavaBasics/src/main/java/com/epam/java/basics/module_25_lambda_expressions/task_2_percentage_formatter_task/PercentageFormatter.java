package com.epam.java.basics.module_25_lambda_expressions.task_2_percentage_formatter_task;

import java.util.function.DoubleFunction;

public interface PercentageFormatter {
    DoubleFunction<String> INSTANCE = d -> String.format("%.1f", d * 100).replace(",", ".").replaceAll("\\.?0+$", "") + " %";
}
