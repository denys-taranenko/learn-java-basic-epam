package com.epam.java.basics.module_10_exceptions.task_2_сatch_em_all;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CatchEmAllTest {

    private ByteArrayOutputStream sink;
    private PrintStream defaultOut;

    @Test
    void testFNF() {
        final FileNotFoundException exception = new FileNotFoundException("fnf");
        CatchEmAll.exception = exception;
        try {
            CatchEmAll.main(new String[0]);
            fail("main must throw an exception");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(exception, e.getCause());
            assertEquals("Resource is missing", e.getMessage());
        }
    }

    @Test
    void testIO() {
        final IOException exception = new IOException("io");
        CatchEmAll.exception = exception;
        try {
            CatchEmAll.main(new String[0]);
            fail("main must throw an exception");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(exception, e.getCause());
            assertEquals("Resource error", e.getMessage());
        }
    }

    @Test
    void testArithmetic() {
        CatchEmAll.exception = new ArithmeticException("ar");
        setControlledErr();
        try {
            CatchEmAll.main(new String[0]);
            assertEquals("ar", sink.toString().trim());
        } catch (Exception e) {
            fail("main must not throw an exception");
        } finally {
            setStandardErr();
        }
    }

    @Test
    void testNFE() {
        CatchEmAll.exception = new NumberFormatException("nfe");
        setControlledErr();
        try {
            CatchEmAll.main(new String[0]);
            assertEquals("nfe", sink.toString().trim());
        } catch (Exception e) {
            fail("main must not throw an exception");
        } finally {
            setStandardErr();
        }
    }

    @Test
    void testUOE() {
        final Exception exception = new UnsupportedOperationException("uoe");
        CatchEmAll.exception = exception;
        try {
            CatchEmAll.main(new String[0]);
            fail("main must throw an exception");
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
            assertEquals(exception, e);
        }
    }

    @Test
    void testUEE() {
        final Exception exception = new UnsupportedEncodingException("uee");
        CatchEmAll.exception = exception;
        try {
            CatchEmAll.main(new String[0]);
            fail("main must throw an exception");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(exception, e.getCause());
            assertEquals("Resource error", e.getMessage());
        }
    }

    @Test
    void testIOOBE() {
        final Exception exception = new IndexOutOfBoundsException("ioobe");
        CatchEmAll.exception = exception;
        try {
            CatchEmAll.main(new String[0]);
            fail("main must throw an exception");
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
            assertEquals(exception, e);
        }
    }


    private void setControlledErr() {
        sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        defaultOut = System.err;

        System.setErr(controlledOut);
    }

    private void setStandardErr() {
        System.setErr(defaultOut);
    }
}