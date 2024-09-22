package com.epam.java.basics.module_20_collection_algorithms.task_1_students_gradebook;

/**
 * @author D.Kolesnikov
 */
public class Student {
    private final String firstName;
    private final String lastName;
    private final String group;

    public Student(String firstName, String lastName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return firstName + "_" + lastName + "_" + group;
    }
}
