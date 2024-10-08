package com.epam.java.basics.module_24_serialization.task_1_serialization;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ItemSerializationTest {

    public static Stream<Arguments> casesSerializeItem() {
        return Stream.of(
                Arguments.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE)),
                Arguments.of(new Item(1L, "item1", "desc1", null, BigDecimal.ONE)),
                Arguments.of(new Item(1L, "item1", "desc1",
                        List.of(
                                new IntItemCharacteristic(1L, "name", "Integer", 5)
                        ),
                        BigDecimal.ONE))
        );

    }

    @ParameterizedTest
    @MethodSource("casesSerializeItem")
    void testSerializeItem(Item original) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(original);
            bos.flush();
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                Item actual = (Item) ois.readObject();
                assertEquals(original, actual,
                        "Deserialized state must be the same as before serialization.");
            } catch (ClassNotFoundException e) {
                fail(e);
            }
        } catch (NotSerializableException e) {
            fail("You can write only serializable classes.", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
