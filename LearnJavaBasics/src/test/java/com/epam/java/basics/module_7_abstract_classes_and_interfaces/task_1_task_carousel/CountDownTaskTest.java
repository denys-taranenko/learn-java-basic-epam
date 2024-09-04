package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_1_task_carousel;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CountDownTaskTest {

    @Test
    void testInputValues() {
        assertEquals(7, new CountDownTask(7).getValue());
        assertEquals(77, new CountDownTask(77).getValue());
        assertEquals(777, new CountDownTask(777).getValue());
        assertEquals(0, new CountDownTask(0).getValue());
        assertEquals(0, new CountDownTask(-7).getValue());
        assertEquals(0, new CountDownTask(-77).getValue());
        assertEquals(0, new CountDownTask(-777).getValue());

        assertFalse(new CountDownTask(1).isFinished());
        assertFalse(new CountDownTask(11).isFinished());
        assertFalse(new CountDownTask(1111111).isFinished());

        assertTrue(new CountDownTask(-1111111).isFinished());
        assertTrue(new CountDownTask(-11).isFinished());
        assertTrue(new CountDownTask(-1).isFinished());
        assertTrue(new CountDownTask(0).isFinished());
    }

    @Test
    void testSingleTaskWorkflow() {
        CountDownTask task = new CountDownTask(7);

        assertFalse(task.isFinished());
        assertEquals(7, task.getValue());

        task.execute();
        assertFalse(task.isFinished());
        assertEquals(6, task.getValue());

        for (int i = 0; i < 5; i++) {
            task.execute();
            assertFalse(task.isFinished());
            assertEquals(5 - i, task.getValue());
        }

        task.execute();
        assertTrue(task.isFinished());
        assertEquals(0, task.getValue());

        for (int i = 0; i < 5; i++) {
            task.execute();
            assertTrue(task.isFinished());
            assertEquals(0, task.getValue());
        }
    }

    @Test
    void testTasksAreIndependent() {
        CountDownTask[] tasks = new Random(8547515)
                .ints(100, 5, 25)
                .mapToObj(CountDownTask::new)
                .toArray(CountDownTask[]::new);

        int completed = 0;
        while (completed < tasks.length) {
            for (CountDownTask task : tasks) {
                int currentValue = task.getValue();
                if (currentValue > 0) {
                    assertFalse(task.isFinished());
                    task.execute();
                    assertEquals(currentValue - 1, task.getValue());
                    if (task.getValue() == 0) {
                        completed++;
                        assertTrue(task.isFinished());
                    }
                } else {
                    assertTrue(task.isFinished());
                    assertEquals(0, task.getValue());
                    task.execute();
                    assertEquals(0, task.getValue());
                    assertTrue(task.isFinished());
                }
            }
        }
    }
}