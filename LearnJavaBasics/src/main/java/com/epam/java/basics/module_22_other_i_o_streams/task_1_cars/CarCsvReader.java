package com.epam.java.basics.module_22_other_i_o_streams.task_1_cars;

import com.epam.java.basics.module_22_other_i_o_streams.task_1_cars.model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CarCsvReader {

    public List<Car> readCars(File file) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(",");
                scanner.useLocale(Locale.US);

                Car car = new Car();

                car.setBrand(scanner.next());
                car.setModel(scanner.next());
                car.setCylinderCapacityCcm(scanner.nextInt());
                car.setPerformanceKwh(scanner.nextInt());
                car.setAccelerationSec(scanner.nextDouble());

                cars.add(car);
                scanner.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }
}
