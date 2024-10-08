package com.epam.java.basics.module_24_serialization.task_1_serialization;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ItemCharacteristicSerializationTest {

    public static Stream<Arguments> casesSerializeItemCharacteristic() {
        return Stream.of(
                Arguments.of(new DoubleItemCharacteristic(1L, "name", "Double", 5)),
                Arguments.of(new IntItemCharacteristic(1L, "name", "Integer", 5))
        );

    }

    @ParameterizedTest
    @MethodSource("casesSerializeItemCharacteristic")
    void testSerializeItemCharacteristic(ItemCharacteristic original) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(original);
            bos.flush();
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                ItemCharacteristic actual = (ItemCharacteristic) ois.readObject();
                assertEquals(original, actual,
                        "You should correctly implement custom serialization");
            } catch (ClassNotFoundException e) {
                fail(e);
            }
        } catch (IOException | ClassCastException e) {
            fail("You can write only serializable classes, ", e);
        }
    }
}
