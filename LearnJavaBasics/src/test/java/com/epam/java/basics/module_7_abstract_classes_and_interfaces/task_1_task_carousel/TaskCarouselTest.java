package com.epam.java.basics.module_7_abstract_classes_and_interfaces.task_1_task_carousel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TaskCarouselTest {

    @Test
    void testSingleTaskWorkflow() {
        TaskCarousel carousel = new TaskCarousel(4);

        assertTrue(carousel.isEmpty());
        assertFalse(carousel.isFull());
        assertFalse(carousel.execute());

        CountDownTask task = new CountDownTask(5);
        assertTrue(carousel.addTask(task));

        assertFalse(carousel.isEmpty());
        assertFalse(carousel.isFull());

        assertEquals(5, task.getValue());
        assertTrue(carousel.execute());
        assertEquals(4, task.getValue());
        assertTrue(carousel.execute());
        assertEquals(3, task.getValue());
        assertTrue(carousel.execute());
        assertEquals(2, task.getValue());
        assertTrue(carousel.execute());
        assertEquals(1, task.getValue());
        assertTrue(carousel.execute());
        assertEquals(0, task.getValue());

        assertFalse(carousel.execute());
        assertTrue(carousel.isEmpty());
        assertFalse(carousel.isFull());
        assertFalse(carousel.execute());
    }

    @Test
    void testAddTasks() {
        TaskCarousel carousel = new TaskCarousel(7);

        assertFalse(carousel.addTask(new CountDownTask(0)));
        assertTrue(carousel.addTask(new CountDownTask(1)));
        assertTrue(carousel.addTask(new CountDownTask(2)));
        assertTrue(carousel.addTask(new CountDownTask(3)));
        assertTrue(carousel.addTask(new CountDownTask(1)));
        assertTrue(carousel.addTask(new CountDownTask(1)));
        assertTrue(carousel.addTask(new CountDownTask(6)));

        assertFalse(carousel.isEmpty());
        assertFalse(carousel.isFull());

        assertTrue(carousel.addTask(new CountDownTask(10)));

        assertFalse(carousel.isEmpty());
        assertTrue(carousel.isFull());

        assertFalse(carousel.addTask(new CountDownTask(10)));
        assertFalse(carousel.addTask(new CountDownTask(100)));
        assertFalse(carousel.addTask(new CompleteByRequestTask()));

        for (int i = 0; i < 7; i++) {
            carousel.execute();
        }

        assertFalse(carousel.isEmpty());
        assertFalse(carousel.isFull());

        assertTrue(carousel.addTask(new CountDownTask(10)));
        assertTrue(carousel.addTask(new CountDownTask(100)));
        assertTrue(carousel.addTask(new CompleteByRequestTask()));

        assertFalse(carousel.isEmpty());
        assertTrue(carousel.isFull());

        assertFalse(carousel.addTask(new CountDownTask(10)));
        assertFalse(carousel.addTask(new CountDownTask(100)));
        assertFalse(carousel.addTask(new CompleteByRequestTask()));

        for (int i = 0; i < 7; i++) {
            carousel.execute();
        }

        assertFalse(carousel.isEmpty());
        assertFalse(carousel.isFull());

        assertTrue(carousel.addTask(new CountDownTask(10)));
        assertFalse(carousel.addTask(new CountDownTask(100)));
        assertFalse(carousel.addTask(new CompleteByRequestTask()));

        assertFalse(carousel.isEmpty());
        assertTrue(carousel.isFull());
    }

    @Test
    void testFourTasksWorkflow1() {
        TaskCarousel carousel = new TaskCarousel(4);

        assertTrue(carousel.isEmpty());
        assertFalse(carousel.isFull());
        assertFalse(carousel.execute());

        CountDownTask[] tasks = new CountDownTask[4];
        for (int i = 0; i < 4; i++) {
            tasks[i] = new CountDownTask(i + 1);
            assertTrue(carousel.addTask(tasks[i]));
        }

        Object[][] expectedSteps = new Object[][]{
                {false, true, 1, 2, 3, 4, true},
                {false, false, 0, 1, 2, 3, true},
                {false, false, 0, 0, 1, 2, true},
                {false, false, 0, 0, 0, 1, true},
                {true, false, 0, 0, 0, 0, false}
        };

        for (Object[] expectedStep : expectedSteps) {
            String errMsg = "Assertion fail on step " + Arrays.deepToString(expectedStep);

            assertEquals(expectedStep[0], carousel.isEmpty(), errMsg);
            assertEquals(expectedStep[1], carousel.isFull(), errMsg);

            assertEquals(expectedStep[2], tasks[0].getValue(), errMsg);
            assertEquals(expectedStep[3], tasks[1].getValue(), errMsg);
            assertEquals(expectedStep[4], tasks[2].getValue(), errMsg);
            assertEquals(expectedStep[5], tasks[3].getValue(), errMsg);

            for (final CountDownTask task : tasks) {
                if (!task.isFinished()) {
                    assertEquals(expectedStep[6], carousel.execute(), errMsg);
                }
            }
        }
    }

    @Test
    void testFourTasksWorkflow2() {
        TaskCarousel carousel = new TaskCarousel(4);

        assertTrue(carousel.isEmpty());
        assertFalse(carousel.isFull());
        assertFalse(carousel.execute());

        CountDownTask[] tasks = new CountDownTask[4];
        for (int i = 0; i < 4; i++) {
            tasks[i] = new CountDownTask(4 - i);
            assertTrue(carousel.addTask(tasks[i]));
        }

        Object[][] expectedSteps = new Object[][]{
                {false, true, 4, 3, 2, 1, true},
                {false, false, 3, 2, 1, 0, true},
                {false, false, 2, 1, 0, 0, true},
                {false, false, 1, 0, 0, 0, true},
                {true, false, 0, 0, 0, 0, false}
        };

        for (Object[] expectedStep : expectedSteps) {
            String errMsg = "Assertion fail on step " + Arrays.deepToString(expectedStep);

            assertEquals(expectedStep[0], carousel.isEmpty(), errMsg);
            assertEquals(expectedStep[1], carousel.isFull(), errMsg);

            assertEquals(expectedStep[2], tasks[0].getValue(), errMsg);
            assertEquals(expectedStep[3], tasks[1].getValue(), errMsg);
            assertEquals(expectedStep[4], tasks[2].getValue(), errMsg);
            assertEquals(expectedStep[5], tasks[3].getValue(), errMsg);

            for (final CountDownTask task : tasks) {
                if (!task.isFinished()) {
                    assertEquals(expectedStep[6], carousel.execute(), errMsg);
                }
            }
        }
    }

    @Test
    void testAddingElements() {
        TaskCarousel carousel = new TaskCarousel(3);

        assertTrue(carousel.isEmpty());
        assertFalse(carousel.isFull());
        assertFalse(carousel.execute());

        assertFalse(carousel.addTask(new CountDownTask(0)));

        assertTrue(carousel.isEmpty());
        assertFalse(carousel.isFull());
        assertFalse(carousel.execute());

        CountDownTask task1 = new CountDownTask(1);
        CountDownTask task2 = new CountDownTask(1);
        CountDownTask task3 = new CountDownTask(1);
        CountDownTask task4 = new CountDownTask(1);

        assertTrue(carousel.addTask(task1));
        assertTrue(carousel.addTask(task2));

        assertTrue(carousel.execute());
        assertEquals(1, task1.getValue() + task2.getValue());

        assertTrue(carousel.addTask(task3));
        assertTrue(carousel.addTask(task4));

        assertTrue(carousel.execute());
        assertTrue(carousel.execute());
        assertTrue(carousel.execute());

        assertEquals(0, task1.getValue());
        assertEquals(0, task2.getValue());
        assertEquals(0, task3.getValue());
        assertEquals(0, task4.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {2342, 8503233, 780347455})
    void testCarouselHandlesALongQueue(final int seed) {
        List<CountDownTask> countDownTasks = new Random(seed)
                .ints(100, 0, 30)
                .mapToObj(CountDownTask::new)
                .toList();

        Queue<CountDownTask> taskQueue = new ArrayDeque<>(countDownTasks);

        TaskCarousel carousel = new TaskCarousel(4);
        while (!taskQueue.isEmpty() || !carousel.isEmpty()) {
            if (!taskQueue.isEmpty() && !carousel.isFull()) {
                CountDownTask countDownTask = taskQueue.poll();
                if (!countDownTask.isFinished()) {
                    assertTrue(carousel.addTask(countDownTask));
                }
            } else {
                assertTrue(carousel.execute());
            }
        }

        for (CountDownTask countDownTask : countDownTasks) {
            assertTrue(countDownTask.isFinished());
            assertEquals(0, countDownTask.getValue());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {42, 8503, 780347455})
    void testCarouselElementsDontStuckOnAnElement(final int seed) {
        List<CountDownTask> countDownTasks = new Random(seed)
                .ints(100, 0, 30)
                .mapToObj(CountDownTask::new)
                .toList();

        Queue<CountDownTask> taskQueue = new ArrayDeque<>(countDownTasks);

        List<CompleteByRequestTask> completeByRequestTasks = List.of(
                new CompleteByRequestTask(),
                new CompleteByRequestTask(),
                new CompleteByRequestTask()
        );

        TaskCarousel carousel = new TaskCarousel(5);
        completeByRequestTasks.forEach(carousel::addTask);
        while (!taskQueue.isEmpty()) {
            if (carousel.isFull()) {
                assertTrue(carousel.execute());
            } else {
                CountDownTask countDownTask = taskQueue.poll();
                if (!countDownTask.isFinished()) {
                    assertTrue(carousel.addTask(countDownTask));
                }
            }
        }

        int finished = 0;
        int zeroValues = 0;
        for (CountDownTask countDownTask : countDownTasks) {
            if (countDownTask.isFinished()) {
                finished++;
            }
            if (countDownTask.getValue() == 0) {
                zeroValues++;
            }
        }

        assertTrue(finished >= 98);
        assertTrue(zeroValues >= 98);

        for (int i = 0; i < 1000; i++) {
            carousel.execute();
        }

        for (CountDownTask countDownTask : countDownTasks) {
            assertTrue(countDownTask.isFinished());
            assertEquals(0, countDownTask.getValue());
        }

        completeByRequestTasks.forEach(CompleteByRequestTask::complete);

        assertFalse(carousel.isEmpty());
        carousel.execute();
        carousel.execute();
        carousel.execute();
        assertTrue(carousel.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {43232, 85012123, 780373455})
    void testCarouselElementsDontStuckOnAnElementLocalMaxima(final int seed) {
        List<CountDownTask> countDownTasks = new Random(seed)
                .ints(100, 0, 30)
                .mapToObj(CountDownTask::new)
                .toList();

        Queue<CountDownTask> taskQueue = new ArrayDeque<>(countDownTasks);

        List<CompleteByRequestTask> completeByRequestTasks = List.of(
                new CompleteByRequestTask(),
                new CompleteByRequestTask()
        );

        TaskCarousel carousel = new TaskCarousel(5);
        carousel.addTask(new CountDownTask(5));
        carousel.addTask(completeByRequestTasks.get(0));
        carousel.addTask(new CountDownTask(15));
        carousel.addTask(completeByRequestTasks.get(1));
        carousel.addTask(new CountDownTask(25));

        while (!taskQueue.isEmpty()) {
            if (carousel.isFull()) {
                assertTrue(carousel.execute());
            } else {
                CountDownTask countDownTask = taskQueue.poll();
                if (!countDownTask.isFinished()) {
                    assertTrue(carousel.addTask(countDownTask));
                }
            }
        }

        int finished = 0;
        int zeroValues = 0;
        for (CountDownTask countDownTask : countDownTasks) {
            if (countDownTask.isFinished()) {
                finished++;
            }
            if (countDownTask.getValue() == 0) {
                zeroValues++;
            }
        }

        assertTrue(finished >= 97);
        assertTrue(zeroValues >= 97);

        for (int i = 0; i < 1000; i++) {
            carousel.execute();
        }

        for (CountDownTask countDownTask : countDownTasks) {
            assertTrue(countDownTask.isFinished());
            assertEquals(0, countDownTask.getValue());
        }

        for (CompleteByRequestTask completeByRequestTask : completeByRequestTasks) {
            assertFalse(completeByRequestTask.isFinished());
        }
        completeByRequestTasks.forEach(CompleteByRequestTask::complete);

        assertFalse(carousel.isEmpty());
        carousel.execute();
        carousel.execute();
        assertTrue(carousel.isEmpty());
    }
}