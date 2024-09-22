package com.epam.java.basics.module_20_collection_algorithms.task_2_maternity_hospital_journal;

import java.util.Objects;

public class Baby {
    private final String name;
    private final double weight;
    private final int height;
    private final String gender;
    private final String time;

    public Baby(String name, double weight, int height, String gender, String time) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return Double.compare(baby.weight, weight) == 0 &&
                height == baby.height &&
                name.equals(baby.name) && gender.equals(baby.gender) &&
                time.equals(baby.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, height, gender, time);
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", gender=" + gender +
                ", time='" + time + '\'' +
                '}';
    }
}
