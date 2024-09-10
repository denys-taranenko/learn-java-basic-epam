package com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.residents.cats;

public class Cat {

    protected String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat " + name;
    }
}