package com.epam.java.basics.module_22_other_i_o_streams.task_1_cars.model;

import java.util.Objects;

public class Car {

    private String brand;
    private String model;
    private int cylinderCapacityCcm;
    private int performanceKwh;
    private double accelerationSec;

    public Car() {
    }

    public Car(String brand, String model, int cylinderCapacityCcm, int performanceKwh, double accelerationSec) {
        this.brand = brand;
        this.model = model;
        this.cylinderCapacityCcm = cylinderCapacityCcm;
        this.performanceKwh = performanceKwh;
        this.accelerationSec = accelerationSec;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCylinderCapacityCcm() {
        return cylinderCapacityCcm;
    }

    public void setCylinderCapacityCcm(int cylinderCapacityCcm) {
        this.cylinderCapacityCcm = cylinderCapacityCcm;
    }

    public int getPerformanceKwh() {
        return performanceKwh;
    }

    public void setPerformanceKwh(int performanceKwh) {
        this.performanceKwh = performanceKwh;
    }

    public double getAccelerationSec() {
        return accelerationSec;
    }

    public void setAccelerationSec(double accelerationSec) {
        this.accelerationSec = accelerationSec;
    }

    @Override
    public String toString() {
        return "Car{" +
                brand + ", " +
                model + ", " +
                cylinderCapacityCcm + ", " +
                performanceKwh + ", " +
                accelerationSec +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (cylinderCapacityCcm != car.cylinderCapacityCcm) return false;
        if (performanceKwh != car.performanceKwh) return false;
        if (Double.compare(car.accelerationSec, accelerationSec) != 0) return false;
        if (!Objects.equals(brand, car.brand)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + cylinderCapacityCcm;
        result = 31 * result + performanceKwh;
        result = 31 * result + Double.hashCode(accelerationSec);
        return result;
    }
}
