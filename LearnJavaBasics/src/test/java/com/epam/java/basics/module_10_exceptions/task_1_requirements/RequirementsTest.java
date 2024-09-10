package com.epam.java.basics.module_10_exceptions.task_1_requirements;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.epam.java.basics.module_10_exceptions.task_1_requirements.Requirements.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class RequirementsTest {

    @Test
    public void checkArgumentTest() {
        assertDoesNotThrow(() -> checkArgument(true));
        assertThrows(IllegalArgumentException.class, () -> checkArgument(false));

        assertDoesNotThrow(() -> checkArgument(true, "a message"));
        for (String message : List.of("hey", "there", "an error message")) {
            try {
                checkArgument(false, message);
            } catch (IllegalArgumentException e) {
                assertEquals(message, e.getMessage());
                continue;
            } catch (Throwable thr) {
                thr.printStackTrace();
                fail("Wrong type of an exception " + thr.getClass() + ":" + thr.getMessage());
            }
            fail("An exception must be thrown");
        }
    }

    @Test
    public void checkStateTest() {
        assertDoesNotThrow(() -> checkState(true));
        assertThrows(IllegalStateException.class, () -> checkState(false));

        assertDoesNotThrow(() -> checkState(true, "a message"));
        for (String message : List.of("hey", "there", "an error message")) {
            try {
                checkState(false, message);
            } catch (IllegalStateException e) {
                assertEquals(message, e.getMessage());
                continue;
            } catch (Throwable thr) {
                thr.printStackTrace();
                fail("Wrong type of an exception " + thr.getClass() + ":" + thr.getMessage());
            }
            fail("An exception must be thrown");
        }
    }

    @Test
    public void requireNonNullTest() {
        assertDoesNotThrow(() -> requireNonNull(new Object()));
        assertThrows(NullPointerException.class, () -> requireNonNull(null));

        assertDoesNotThrow(() -> requireNonNull(new Object(), "a message"));
        for (String message : List.of("hey", "there", "an error message")) {
            try {
                requireNonNull(null, message);
            } catch (NullPointerException e) {
                assertEquals(message, e.getMessage());
                continue;
            } catch (Throwable thr) {
                thr.printStackTrace();
                fail("Wrong type of an exception " + thr.getClass() + ":" + thr.getMessage());
            }
            fail("An exception must be thrown");
        }
    }

    @Test
    public void checkElementIndex() {
        assertDoesNotThrow(() -> checkIndex(0, 10));
        assertDoesNotThrow(() -> checkIndex(3, 10));
        assertDoesNotThrow(() -> checkIndex(9, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> checkIndex(9, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> checkIndex(3, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> checkIndex(-1, 2));
    }
}