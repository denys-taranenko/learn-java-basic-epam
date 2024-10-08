package com.epam.java.basics.module_24_serialization.task_1_serialization;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderSerializationTest {

    public static Stream<Arguments> casesOrderTotal() {
        return Stream.of(
                Arguments.of(new Order(1L, null), BigDecimal.ZERO),
                Arguments.of(new Order(1L, Map.of()), BigDecimal.ZERO),
                Arguments.of(new Order(1L, Map.of(
                                new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                                new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1)),
                        BigDecimal.ONE),
                Arguments.of(new Order(1L, Map.of(
                                new Item(1L, "item1", "desc1", List.of(), new BigDecimal("5.2")), 1,
                                new Item(2L, "item2", "desc2", List.of(), new BigDecimal("0.2")), 1)),
                        new BigDecimal("5.4")),
                Arguments.of(new Order(1L, Map.of(
                                new Item(1L, "item1", "desc1", List.of(), new BigDecimal("3.1")), 3,
                                new Item(2L, "item2", "desc2", List.of(), new BigDecimal("0.2")), 2)),
                        new BigDecimal("9.7"))
        );
    }

    @ParameterizedTest
    @MethodSource("casesOrderTotal")
    void testOrderTotal(Order order, BigDecimal expectedTotal) {
        assertEquals(expectedTotal, order.getTotal());
    }

    @Test
    void testSerializeOrder() {
        Order original = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", null, new BigDecimal("2.0")), 2));
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            // serialize
            assertEquals(new BigDecimal("5.0"), original.getTotal());
            OrderSerializer.serializeOrder(original, bos);
            bos.flush();
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray())) {
                // deserialize
                Order actual = OrderSerializer.deserializeOrder(bis);
                assertEquals(original, actual,
                        "The 'total' field must not be serialized.");
                // total is not serialized
                assertActualTotalEquals(actual
                );
                assertEquals(original.getTotal(), actual.getTotal(),
                        "The 'getTotal()' method must set the 'total' field.");
            } catch (ClassNotFoundException e) {
                fail(e);
            }
        } catch (NotSerializableException e) {
            fail("You can write only serializable classes, ", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void assertActualTotalEquals(Order order) {
        try {
            Field totalField = Order.class.getDeclaredField("total");
            totalField.setAccessible(true);
            BigDecimal actual = (BigDecimal) totalField.get(order);
            assertNull(actual, "The 'total' field must not be serialized");
        } catch (NoSuchFieldException e) {
            fail("Order class must have the 'total' field.", e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
