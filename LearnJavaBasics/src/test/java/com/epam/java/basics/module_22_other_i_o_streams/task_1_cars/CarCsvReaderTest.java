package com.epam.java.basics.module_22_other_i_o_streams.task_1_cars;

import com.epam.java.basics.module_22_other_i_o_streams.task_1_cars.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class CarCsvReaderTest {

    private final CarCsvReader underTest = new CarCsvReader();

    @Test
    public void readCarsFromCsvFileTest() {
        List<Car> expectedCars = List.of(
                new Car("Toyota", "Corolla", 1599, 75, 6.8),
                new Car("Kia", "Rio", 1250, 68, 10.30),
                new Car("VW", "Polo", 1595, 105, 8.4)
        );
        List<Car> actualCars = underTest.readCars(new File("data/cars.csv"));
        Assertions.assertIterableEquals(expectedCars, actualCars,
                "Cars read from cars.csv file and expected list of cars are different.");
    }
}
