package com.epam.java.basics.module_22_other_i_o_streams.task_1_cars;

import com.epam.java.basics.module_22_other_i_o_streams.task_1_cars.model.Car;

import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class FormattedCarPrinter {

    public void print(List<Car> cars) {
        String regex = "%10s %10s %5d ccm %3d kw %5.2f sec%n";
        StringBuilder output = new StringBuilder();

        try (Formatter formatter = new Formatter(output, Locale.US)) {
            for (Car car : cars) {
                formatter.format(regex,
                        car.getBrand(),
                        car.getModel(),
                        car.getCylinderCapacityCcm(),
                        car.getPerformanceKwh(),
                        car.getAccelerationSec());
            }
        }
        System.out.print(output);
    }
}
