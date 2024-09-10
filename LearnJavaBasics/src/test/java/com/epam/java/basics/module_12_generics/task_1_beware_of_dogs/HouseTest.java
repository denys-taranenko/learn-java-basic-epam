package com.epam.java.basics.module_12_generics.task_1_beware_of_dogs;


import com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.house.House;
import com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.residents.cats.Cat;
import com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.residents.cats.Kitten;
import com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.residents.dogs.Dog;
import com.epam.java.basics.module_12_generics.task_1_beware_of_dogs.residents.dogs.Puppy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseTest {

    @Test
    void shouldCheckGenericTypeParameters() {
        Type[] houseTypes = House.class.getTypeParameters();
        Assertions.assertEquals(1, houseTypes.length, "You must parametrize the House class");
        String houseType = houseTypes[0].getTypeName();
        try {
            Field field = House.class.getDeclaredField("residents");
            Assertions.assertEquals(field.getGenericType().getTypeName(),
                    "java.util.List<" + houseType + ">",
                    "You must parametrize the House class");
        } catch (NoSuchFieldException e) {
            Assertions.fail("'House' class should contain 'residents' field");
        }
    }

    @Test
    void testHouseResidents() {
        Dog rex = new Dog("Rex");
        Puppy randy = new Puppy("Randy");
        Cat barbos = new Cat("Barbos");
        Kitten murzik = new Kitten("Murzik");

        House dogHouse = new House();
        dogHouse.enter(rex);
        assertEquals("There are following residents in the house:\n" +
                        "Dog Rex",
                dogHouse.toString().strip());
        dogHouse.enter(randy);
        assertEquals("""
                        There are following residents in the house:
                        Dog Rex
                        Puppy Randy""",
                dogHouse.toString().strip());

        House catHouse = new House();
        catHouse.enter(barbos);
        assertEquals("There are following residents in the house:\n" +
                        "Cat Barbos",
                catHouse.toString().strip());
        catHouse.enter(murzik);
        assertEquals("""
                There are following residents in the house:
                Cat Barbos
                Kitten Murzik""", catHouse.toString().strip());
    }
}