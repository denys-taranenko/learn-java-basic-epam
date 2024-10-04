package com.epam.java.basics.module_22_other_i_o_streams.task_1_cars;

import com.epam.java.basics.module_22_other_i_o_streams.task_1_cars.model.Car;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormattedCarPrinterTest {

    private final FormattedCarPrinter underTest = new FormattedCarPrinter();

    @Test
    public void formattedPrintCarTest() {
        String expected = "    Toyota    Corolla  1599 ccm  75 kw  6.80 sec" + System.lineSeparator() +
                "       Kia        Rio  1250 ccm  68 kw 10.30 sec" + System.lineSeparator() +
                "        VW       Polo  1595 ccm 105 kw  8.40 sec";
        List<Car> cars = createTestCars();

        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;
        System.setOut(controlledOut);

        try {
            underTest.print(cars);
            controlledOut.flush();
            final String actual = sink.toString().stripTrailing();
            assertEquals(expected, actual, "Expected console output and actual output are different.");
        } finally {
            System.setOut(defaultOut);
        }
    }

    private List<Car> createTestCars() {
        return List.of(
                new Car("Toyota", "Corolla", 1599, 75, 6.80),
                new Car("Kia", "Rio", 1250, 68, 10.3),
                new Car("VW", "Polo", 1595, 105, 8.40)
        );
    }
}
