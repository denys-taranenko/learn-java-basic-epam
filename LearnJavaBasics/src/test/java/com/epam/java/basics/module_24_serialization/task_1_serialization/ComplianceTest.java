package com.epam.java.basics.module_24_serialization.task_1_serialization;

import org.junit.jupiter.api.Test;

import java.io.Externalizable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ComplianceTest {
    @Test
    void testCompliance() {
        testComplianceItemCharacteristic();
        testComplianceNotExternalizable(Order.class);
        testComplianceNotExternalizable(Item.class);
        testComplianceNotExternalizable(ItemCharacteristic.class);
        testComplianceNotExternalizable(IntItemCharacteristic.class);
        testComplianceNotExternalizable(DoubleItemCharacteristic.class);
        testDoubleItemCharacteristicEquals();
        testDoubleItemCharacteristicInheritance();
        testIntItemCharacteristicEquals();
        testIntItemCharacteristicInheritance();
        testItemEquals();
        testOrderEquals();
        testOrderTotalIsReadonly();
        testOrderItemsIsReadonly();
        testOrderTotalIsExcludedFromEquals();
        testOrderTotalIsExcludedFromHashCode();
        testOrderTotalIsCalculatedOnce();
    }

    void testOrderTotalIsReadonly() {
        assertThrows(NoSuchMethodException.class, () -> Order.class.getDeclaredMethod("setTotal", BigDecimal.class));
    }

    void testOrderItemsIsReadonly() {
        assertThrows(NoSuchMethodException.class, () -> Order.class.getDeclaredMethod("setItems", Map.class));
    }

    void testComplianceItemCharacteristic() {
        int modifiers = ItemCharacteristic.class.getModifiers();
        assertTrue(Modifier.isAbstract(modifiers),
                "'ItemCharacteristic' must be abstract.");
        Class<?>[] interfaces = ItemCharacteristic.class.getInterfaces();
        assertTrue(Arrays.stream(interfaces).noneMatch(i -> i == Serializable.class),
                "'ItemCharacteristic' must not implement 'Serializable'");
    }

    void testComplianceNotExternalizable(Class<?> c) {
        Class<?>[] interfaces = ItemCharacteristic.class.getInterfaces();
        assertTrue(Arrays.stream(interfaces).noneMatch(i -> i == Externalizable.class),
                "'" + c.getSimpleName() + "' must not implement 'Externalizable'");

    }

    void testIntItemCharacteristicEquals() {
        ItemCharacteristic ic1 = new IntItemCharacteristic(1L, "intChar", "str", 25);
        int hash = ic1.hashCode();

        ItemCharacteristic ic2 = new IntItemCharacteristic(1L, "intChar", "str", 25);
        assertEquals(ic1, ic2,
                "The 'IntItemCharacteristic#equals()' method must be implemented");
        assertEquals(hash, ic2.hashCode(),
                "The 'IntItemCharacteristic#hashCode()' method must be implemented");

        ic2 = new IntItemCharacteristic(0L, null, "str", 25);
        assertNotEquals(ic1, ic2,
                "The 'IntItemCharacteristic#equals()' method must be implemented");
        assertNotEquals(hash, ic2.hashCode(),
                "The 'IntItemCharacteristic#hashCode()' method must include all fields");

        ic2 = new IntItemCharacteristic(1L, "intChar", null, 25);
        assertNotEquals(ic1, ic2,
                "The 'IntItemCharacteristic#equals()' method must be implemented");
        assertNotEquals(hash, ic2.hashCode(),
                "The 'IntItemCharacteristic#hashCode()' method must include all fields");

        ic2 = new IntItemCharacteristic(1L, "intChar", "str", 5);
        assertNotEquals(ic1, ic2,
                "The 'IntItemCharacteristic#equals()' method must be implemented");
        assertNotEquals(hash, ic2.hashCode(),
                "The 'IntItemCharacteristic#hashCode()' method must include all fields");
    }

    void testDoubleItemCharacteristicInheritance() {
        assertEquals(ItemCharacteristic.class, DoubleItemCharacteristic.class.getSuperclass(),
                "DoubleItemCharacteristic must inherit ItemCharacteristic");
    }

    void testIntItemCharacteristicInheritance() {
        assertEquals(ItemCharacteristic.class, IntItemCharacteristic.class.getSuperclass(),
                "DoubleItemCharacteristic must inherit ItemCharacteristic");
    }

    void testDoubleItemCharacteristicEquals() {
        ItemCharacteristic ic1 = new DoubleItemCharacteristic(1L, "intChar", "str", 25);
        int hash = ic1.hashCode();

        ItemCharacteristic ic2 = new DoubleItemCharacteristic(1L, "intChar", "str", 25);
        assertEquals(ic1, ic2,
                "The 'DoubleItemCharacteristic#equals()' method must be implemented");
        assertEquals(hash, ic2.hashCode(),
                "The 'DoubleItemCharacteristic#hashCode()' method must be implemented");

        ic2 = new DoubleItemCharacteristic(0L, "intChar", "str", 25);
        assertNotEquals(ic1, ic2,
                "The 'DoubleItemCharacteristic#equals()' method must include all fields");
        assertNotEquals(hash, ic2.hashCode(),
                "The 'DoubleItemCharacteristic#hashCode()' method must include all fields");

        ic2 = new DoubleItemCharacteristic(1L, null, "str", 5);
        assertNotEquals(ic1, ic2,
                "The 'DoubleItemCharacteristic#equals()' method must include all fields");
        assertNotEquals(hash, ic2.hashCode(),
                "The 'DoubleItemCharacteristic#hashCode()' method must include all fields");

        ic2 = new DoubleItemCharacteristic(1L, "intChar", "null", 25);
        assertNotEquals(ic1, ic2,
                "The 'DoubleItemCharacteristic#equals()' method must include all fields");
        assertNotEquals(hash, ic2.hashCode(),
                "The 'DoubleItemCharacteristic#hashCode()' method must include all fields");
    }

    void testItemEquals() {
        Item it1 = new Item(1L, "item1", "desc1", List.of(), BigDecimal.ZERO);
        int hash = it1.hashCode();

        Item it2 = new Item(1L, "item1", "desc1", List.of(), BigDecimal.ZERO);
        assertEquals(it1, it2,
                "The 'Item#equals()' method must be implemented");
        assertEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must be implemented");

        it2 = new Item(0L, "item1", "desc1", List.of(), BigDecimal.ZERO);
        assertNotEquals(it1, it2,
                "The 'Item#equals()' method must include all fields");
        assertNotEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must include all fields");

        it2 = new Item(1L, null, "desc1", List.of(), BigDecimal.ZERO);
        assertNotEquals(it1, it2,
                "The 'Item#equals()' method must include all fields");
        assertNotEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must include all fields");

        it2 = new Item(1L, "item1", "desc2", List.of(), BigDecimal.ZERO);
        assertNotEquals(it1, it2,
                "The 'Item#equals()' method must include all fields");
        assertNotEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must include all fields");

        it2 = new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE);
        assertNotEquals(it1, it2,
                "The 'Item#equals()' method must include all fields");
        assertNotEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must include all fields");

        it2 = new Item(1L, "item1", "desc1", null, BigDecimal.ZERO);
        assertNotEquals(it1, it2,
                "The 'Item#equals()' method must include all fields");
        assertNotEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must include all fields");

        it1 = new Item(1L, "item1", "desc1", List.of(
                new DoubleItemCharacteristic(2L, "intChar", "null", 25)),
                BigDecimal.ZERO);
        assertNotEquals(it1, it2,
                "The 'Item#equals()' method must include all fields");
        assertNotEquals(hash, it2.hashCode(),
                "The 'Item#hashCode()' method must include all fields");
    }

    void testOrderEquals() {
        Order o1 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        int hash = o1.hashCode();

        Order o2 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        assertEquals(o1, o2,
                "The 'Order#equals()' method must be implemented");
        assertEquals(hash, o2.hashCode(),
                "The 'Order#hashCode()' method must be implemented");

        o2 = new Order(0L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        assertNotEquals(o1, o2,
                "The 'Order#equals()' method must include all fields except 'total'");
        assertNotEquals(hash, o2.hashCode(),
                "The 'Order#hashCode()' method must include all fields except 'total'");

        o2 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1));
        assertNotEquals(o1, o2,
                "The 'Order#equals()' method must include all fields except 'total'");
        assertNotEquals(hash, o2.hashCode(),
                "The 'Order#hashCode()' method must include all fields except 'total'");

    }

    void testOrderTotalIsExcludedFromEquals() {
        Order o1 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        Order o2 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        assertEquals(o1, o2,
                "The 'Order#equals()' method must be implemented");

        try {
            Field total = Order.class.getDeclaredField("total");
            total.setAccessible(true);
            total.set(o2, new BigDecimal("45."));
            assertEquals(o1, o2, "Order#equals() must not use the 'total' field.");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("The 'Order#total' filed must be declared");
        }
    }

    void testOrderTotalIsExcludedFromHashCode() {
        Order o1 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        Order o2 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        assertEquals(o1.hashCode(), o2.hashCode(),
                "The 'Order#hashCode()' method must be implemented");

        try {
            Field total = Order.class.getDeclaredField("total");
            total.setAccessible(true);
            total.set(o2, new BigDecimal("45."));
            assertEquals(o1.hashCode(), o2.hashCode(), "Order#hashCode() must not include the 'total' field.");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("The 'total' filed must be declared");
        }
    }

    void testOrderTotalIsCalculatedOnce() {
        Order o1 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        Order o2 = new Order(1L,
                Map.of(new Item(1L, "item1", "desc1", List.of(), BigDecimal.ONE), 1,
                        new Item(2L, "item2", "desc2", List.of(), BigDecimal.ZERO), 1));
        assertEquals(o1, o2);

        try {
            Field total = Order.class.getDeclaredField("total");
            total.setAccessible(true);
            total.set(o2, new BigDecimal("45."));
            assertEquals(new BigDecimal("45."), o2.getTotal(),
                    "The 'total' must not be calculated each time.");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("The 'total' filed must be declared");
        }
    }
}
