package com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.house;

import java.util.ArrayList;
import java.util.List;

public class House<T> {

    private final List<T> residents = new ArrayList<>();

    public void enter(T resident) {
        residents.add(resident);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}