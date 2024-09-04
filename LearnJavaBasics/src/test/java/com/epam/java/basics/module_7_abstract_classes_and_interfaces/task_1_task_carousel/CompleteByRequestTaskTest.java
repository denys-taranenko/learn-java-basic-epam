package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_1_task_carousel;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CompleteByRequestTaskTest {

    @Test
    void testSingleTaskWorkflow() {
        CompleteByRequestTask task = new CompleteByRequestTask();

        assertFalse(task.isFinished());

        task.execute();
        assertFalse(task.isFinished());

        for (int i = 0; i < 100; i++) {
            task.execute();
        }
        assertFalse(task.isFinished());

        task.complete();
        assertFalse(task.isFinished());

        task.execute();
        assertTrue(task.isFinished());

        task.execute();
        assertTrue(task.isFinished());
    }

    @Test
    void testTasksAreIndependent() {
        int amount = 100;
        int[] iterations = new Random(9475934)
                .ints(amount, 5, 25)
                .toArray();

        CompleteByRequestTask[] tasks = Stream.generate(CompleteByRequestTask::new)
                .limit(amount)
                .toArray(CompleteByRequestTask[]::new);

        int completed = 0;
        while (completed < amount) {
            for (int i = 0; i < iterations.length; i++) {
                CompleteByRequestTask task = tasks[i];
                if (iterations[i] == 0) {
                    assertTrue(task.isFinished());
                } else {
                    assertFalse(task.isFinished());
                    iterations[i]--;
                    if (iterations[i] == 0) {
                        task.complete();
                        completed++;
                    }
                    assertFalse(task.isFinished());
                    task.execute();
                }
            }
        }

    }
}