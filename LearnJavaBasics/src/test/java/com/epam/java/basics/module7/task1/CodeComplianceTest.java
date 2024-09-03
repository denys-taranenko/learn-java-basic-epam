package com.epam.java.basics.module7.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeComplianceTest {
    @Test
    void testTaskIsInterface() {
        assertTrue(Task.class.isInterface());
    }

    @Test
    void testImplementsTask() {
        assertTrue(Arrays.asList(CountDownTask.class.getInterfaces()).contains(Task.class));
        assertTrue(Arrays.asList(CompleteByRequestTask.class.getInterfaces()).contains(Task.class));
    }
}