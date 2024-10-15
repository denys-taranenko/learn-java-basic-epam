package com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.builder;


import com.epam.java.basics.module_26_stream_api.task_2_stream_api_intermediate.model.Person;

import java.time.LocalDate;

public class PersonBuilder {
    private String name;
    private LocalDate dateOfBirth;
    private String bio;

    public PersonBuilder() {}
    public PersonBuilder(String name) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(1970, 1, 1);
        bio = "";
    }
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public PersonBuilder setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public Person build() {
        Person person = new Person();
        validateName(name);
        person.setName(name);
        validateDateOfBirth(dateOfBirth);
        person.setDateOfBirth(dateOfBirth);
        person.setBio(bio);
        return person;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.isBlank() || !name.matches("[a-zA-Z\\-. ]+")) {
            throw new IllegalArgumentException("Name (" + name + ") is not valid!");
        }
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isBefore(LocalDate.of(1800, 1, 1))) {
            throw new IllegalArgumentException("Date of Birth (" + dateOfBirth + ") is not valid!");
        }
    }
}
