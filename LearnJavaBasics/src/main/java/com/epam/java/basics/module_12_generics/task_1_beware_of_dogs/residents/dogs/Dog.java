package com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.residents.dogs;

public class Dog {

    protected String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog " + name;
    }
}