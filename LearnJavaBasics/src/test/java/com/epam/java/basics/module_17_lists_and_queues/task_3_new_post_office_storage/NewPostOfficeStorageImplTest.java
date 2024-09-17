package com.epam.java.basics.module_17_lists_and_queues.task_3_new_post_office_storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NewPostOfficeStorageImplTest {
    Box box1;
    Box box2;
    Box box3;
    Box box4;
    List<Box> goodBoxes;
    List<Box> failBoxes;

    @BeforeEach
    void setUp() {
        box1 = new Box("addresser1", "recipient2",
                1.0, 2.5, new BigDecimal("105.5"),
                "city", 1);
        box2 = new Box("addresser2", "recipient3",
                2.0, 1.5, new BigDecimal("25.5"),
                "city", 2);
        box3 = new Box("addresser3", "recipient3",
                3.0, 3.5, new BigDecimal("75.5"),
                "city", 3);
        box4 = new Box("addresser4", "recipient4",
                4.0, 4.5, new BigDecimal("15.5"),
                "city", 4);

        goodBoxes = Arrays.asList(box1, box2, box3);
        failBoxes = Arrays.asList(box1, null, box2);
    }

    @Test
    void testConstructorShouldCreate() {
        assertDoesNotThrow(() -> new NewPostOfficeStorageImpl(),
                "It must not throw an exception for valid data");
        assertDoesNotThrow(() -> new NewPostOfficeStorageImpl(goodBoxes),
                "It must not throw an exception for valid data");
    }

    @Test
    void testConstructorShouldThrow() {
        assertThrows(NullPointerException.class, () -> new NewPostOfficeStorageImpl(null),
                "It must throw NullPointerException if parameter is null");
        assertThrows(NullPointerException.class, () -> new NewPostOfficeStorageImpl(failBoxes),
                "It must not permit null values.");
    }

    @Test
    void testAcceptBox() {
        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl();
        try {
            Box box = box1.clone();
            assertDoesNotThrow(() -> storage.acceptBox(box),
                    "It must not throw exception if parameter is not null");
            assertThrows(NullPointerException.class, () -> storage.acceptBox(null),
                    "It must throw NullPointerException if parameter is null");
            assertEquals(List.of(box1), storage.searchBoxes(e -> true));
            assertTrue(storage.acceptBox(box1));
        } catch (CloneNotSupportedException e) {
            fail("You must not modify existing classes except 'NewPostOfficeStorageImpl'");
        }
    }

    @Test
    void testAcceptAllBoxes() {
        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl();
        assertTrue(storage.acceptAllBoxes(goodBoxes),
                "must return true if the storage is changed");
        List<Box> expected = cloneList(goodBoxes);
        List<Box> actual = storage.searchBoxes(e -> true);
        assertEquals(expected, actual,
                "Must append all provided elements in the same order");

        storage = new NewPostOfficeStorageImpl(goodBoxes);
        storage.acceptAllBoxes(goodBoxes);
        actual = storage.searchBoxes(e -> true);
        expected = Stream.concat(expected.stream(), expected.stream()).toList();
        assertEquals(expected, actual,
                "This container does not check uniqueness because 'Box' does not have any unique field. " +
                        "It must append all provided elements in the same order.");

        assertThrows(NullPointerException.class,
                () -> new NewPostOfficeStorageImpl().acceptAllBoxes(null),
                "It must not permit null values.");
        assertThrows(NullPointerException.class,
                () -> new NewPostOfficeStorageImpl().acceptAllBoxes(failBoxes),
                "It must not permit null values.");
        assertEquals(expected, actual,
                "It must add either all of the provided elements or nothing, " +
                        "if an exception occurs.");
        assertThrows(NullPointerException.class,
                () -> new NewPostOfficeStorageImpl(goodBoxes).acceptAllBoxes(failBoxes),
                "It must not permit null values.");
        assertEquals(expected, actual,
                "It must add either all of the provided elements or nothing, " +
                        "if an exception occurs.");
    }

    @Test
    void testCarryOutBoxes() {
        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl(goodBoxes);
        assertTrue(storage.carryOutBoxes(List.of(box1, box3)),
                "Must return 'true' if the storage was changed.");
        assertFalse(storage.carryOutBoxes(List.of(box4, box3)),
                "Must return 'false' if the storage was not changed.");
        List<Box> expectedIn = cloneList(List.of(box2));
        assertEquals(expectedIn, storage.searchBoxes(e -> true),
                "It must leave all elements in the storage " +
                        "that are not provided in the parameter.");

        storage = new NewPostOfficeStorageImpl(goodBoxes);
        assertTrue(storage.carryOutBoxes(List.of(box2, box4)),
                "Must return 'true' if the storage is changed.");
        expectedIn = cloneList(List.of(box1, box3));
        assertEquals(expectedIn, storage.searchBoxes(e -> true),
                "It must leave all elements " +
                        "that are not provided in the parameter.");
    }

    @Test
    void testSearchBoxes() {
        NewPostOfficeStorageImpl storage = new NewPostOfficeStorageImpl(goodBoxes);
        List<Box> expected = this.goodBoxes;
        List<Box> actual = storage.searchBoxes(e -> true);
        assertIterableEquals(expected, actual,
                "Expected: " + expected + " but was: " + actual);
        expected = List.of(box1);
        actual = storage.searchBoxes(e -> e.getWeight() < 2.);
        assertIterableEquals(expected, actual,
                "Expected: " + expected + " but was: " + actual);
        expected = List.of(box3);
        actual = storage.searchBoxes(e -> e.getVolume() >= 3.5);
        assertIterableEquals(expected, actual,
                "Expected: " + expected + " but was: " + actual);
        expected = List.of(box1, box3);
        actual = storage.searchBoxes(e -> e.getCost().compareTo(new BigDecimal("25.5")) > 0);
        assertIterableEquals(expected, actual,
                "Expected: " + expected + " but was: " + actual);
        expected = List.of(box1, box2);
        actual = storage.searchBoxes(e -> e.getOfficeNumber() < 3);
        assertIterableEquals(expected, actual,
                "Expected: " + expected + " but was: " + actual);
    }

    @Test
    void testCarryOutBoxesShouldThrow() {
        NewPostOfficeStorageImpl storage = new NewPostOfficeStorageImpl(goodBoxes);
        assertThrows(NullPointerException.class,
                () -> storage.carryOutBoxes(failBoxes),
                "Must throw 'NullPointerException' if parameter 'null' or contains 'null' values");
        assertIterableEquals(storage.searchBoxes(e -> true), goodBoxes,
                "Internal state of storage must not be changed if an exception was thrown");
    }

    @Test
    void testCarryOutBoxesWithPredicate() {
        assertThrows(NullPointerException.class,
                () -> new NewPostOfficeStorageImpl(goodBoxes).carryOutBoxes((Predicate<Box>) null),
                "It must throw NullPointerException if the parameter is 'null'");
        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl(goodBoxes);
        storage.acceptAllBoxes(cloneList(goodBoxes));
        List<Box> outBoxes = storage.carryOutBoxes(e -> e.getOfficeNumber() != 1);
        List<Box> expectedIn = cloneList(List.of(box1, box1));
        List<Box> expectedRemoved = cloneList(List.of(box2, box3, box2, box3));
        assertEquals(expectedRemoved, outBoxes,
                "It must remove all elements from the storage " +
                        "that satisfies the predicate");
        assertEquals(expectedIn, storage.searchBoxes(e -> true),
                "It must leave all elements in the storage " +
                        "that does not satisfies the predicate");
    }

    @Test
    void testGetAllWeightLessThan() {
        NewPostOfficeStorage mock = mock(NewPostOfficeStorageImpl.class);
        when(mock.getAllWeightLessThan(Mockito.anyDouble())).thenCallRealMethod();
        mock.getAllWeightLessThan(1.);

        verify(mock, atLeastOnce()
                .description("It's highly recommended to use an existing method to searchBoxes the storage."))
                .searchBoxes(any(Predicate.class));

        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl(goodBoxes);
        List<Box> allWeightLessThan = storage.getAllWeightLessThan(1.);
        assertTrue(allWeightLessThan.isEmpty(),
                "There are no parcels with weight less then 1. but found: "
                        + allWeightLessThan);
        allWeightLessThan = storage.getAllWeightLessThan(2.);
        assertEquals(cloneList(List.of(box1)), allWeightLessThan,
                "There is only one parcel with weight less then 2. but found: "
                        + allWeightLessThan);
        allWeightLessThan = storage.getAllWeightLessThan(20.);
        assertEquals(storage.searchBoxes(e -> true), allWeightLessThan,
                "All parcels satisfy the condition weight less then 20. but found: "
                        + allWeightLessThan);
        assertThrows(IllegalArgumentException.class, () -> storage.getAllWeightLessThan(0.),
                "See JavaDoc on 'NewPostOfficeStorage#getAllWeightLessThan'");
        assertThrows(IllegalArgumentException.class, () -> storage.getAllWeightLessThan(-0.0001),
                "See JavaDoc on 'NewPostOfficeStorage#getAllWeightLessThan'");
    }

    @Test
    void testGetAllCostGreaterThan() {
        NewPostOfficeStorage mock = mock(NewPostOfficeStorageImpl.class);
        when(mock.getAllCostGreaterThan(any())).thenCallRealMethod();
        mock.getAllCostGreaterThan(BigDecimal.ONE);
        verify(mock, atLeastOnce()
                .description("It's highly recommended to reuse an existing method " +
                        "to searchBoxes in the storage."))
                .searchBoxes(any(Predicate.class));

        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl(goodBoxes);
        List<Box> allCostGreaterThan = storage.getAllCostGreaterThan(new BigDecimal("105.5"));
        assertTrue(allCostGreaterThan.isEmpty(),
                "There are no parcels with cost greater then 105.5 but found: "
                        + allCostGreaterThan);
        allCostGreaterThan = storage.getAllCostGreaterThan(new BigDecimal("105.4"));
        assertEquals(cloneList(List.of(box1)), allCostGreaterThan,
                "There is only one parcel with cost greater then 105.4 but found: "
                        + allCostGreaterThan);
        allCostGreaterThan = storage.getAllCostGreaterThan(new BigDecimal("25.5"));
        assertEquals(cloneList(List.of(box1, box3)), allCostGreaterThan,
                "There are two parcels with cost greater then 25.5 but found: "
                        + allCostGreaterThan);
        assertEquals(cloneList(goodBoxes), storage.getAllCostGreaterThan(BigDecimal.ZERO),
                "All parcels satisfy the condition 'cost greater then 0.0' but found: "
                        + allCostGreaterThan);
        assertThrows(NullPointerException.class, () -> storage.getAllCostGreaterThan(null),
                "See JavaDoc on 'NewPostOfficeStorage#getAllCostGreaterThan'");
        assertThrows(IllegalArgumentException.class,
                () -> storage.getAllCostGreaterThan(new BigDecimal("-0.0001")),
                "See JavaDoc on 'NewPostOfficeStorage#getAllCostGreaterThan'");
    }

    @Test
    void testGetAllVolumeGreaterOrEqual() {
        NewPostOfficeStorage mock = mock(NewPostOfficeStorageImpl.class);
        when(mock.getAllVolumeGreaterOrEqual(anyDouble())).thenCallRealMethod();
        mock.getAllVolumeGreaterOrEqual(0.0);
        verify(mock, atLeastOnce()
                .description("It's highly recommended to use an existing method " +
                        "to searchBoxes the storage."))
                .searchBoxes(any(Predicate.class));

        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl(goodBoxes);
        List<Box> allVolumeGreaterOrEqual = storage.getAllVolumeGreaterOrEqual(3.50000001);
        assertTrue(allVolumeGreaterOrEqual.isEmpty(),
                "There are no parcels with volume greater then or equal '3.50000001' but found: "
                        + allVolumeGreaterOrEqual);
        allVolumeGreaterOrEqual = storage.getAllVolumeGreaterOrEqual(3.5);
        assertEquals(cloneList(List.of(box3)), allVolumeGreaterOrEqual,
                "There is only one parcel with volume greater then or equal '3.5' but was: "
                        + allVolumeGreaterOrEqual);
        allVolumeGreaterOrEqual = storage.getAllVolumeGreaterOrEqual(0.0);
        assertEquals(goodBoxes, allVolumeGreaterOrEqual,
                "All parcels satisfy the condition 'volume greater then or equal 0.0' but was: "
                        + allVolumeGreaterOrEqual);
        assertThrows(IllegalArgumentException.class, () -> storage.getAllVolumeGreaterOrEqual(-0.00001),
                "See JavaDoc on 'NewPostOfficeStorage#getAllVolumeGreaterOrEqual'");
    }

    @Test
    void testUpdateOffice() {
        List<Box> boxes = cloneList(goodBoxes);
        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl(boxes);
        List<Box> boxesToFilter = cloneList(boxes);
        storage.updateOfficeNumber(e -> true, 1);
        boxes.forEach(e -> assertEquals(1, e.getOfficeNumber(),
                "Expected office number is '1' but was " + e.getOfficeNumber() +
                        ", '" + e + "'"));

        // Must not change office number in parameter list
        Iterator<Box> it = goodBoxes.iterator();
        assertEquals(0, boxesToFilter.stream().filter(e -> !e.equals(it.next())).count(),
                "You must not set a new value to the parameter elements");

        storage = new NewPostOfficeStorageImpl(goodBoxes);
        storage.updateOfficeNumber(e -> e.getOfficeNumber() < 3, 5);
        assertEquals(5, box1.getOfficeNumber(),
                "office number should be '5'");
        assertEquals(5, box2.getOfficeNumber(),
                "office number should be '5'");
        assertEquals(3, box3.getOfficeNumber(),
                "office number should be '3'");
        assertEquals(4, box4.getOfficeNumber(),
                "office number should be '4'");
    }

    private static List<Box> cloneList(List<Box> boxes) {
        return boxes.stream().map(e -> {
            try {
                return e.clone();
            } catch (CloneNotSupportedException ex) {
                fail();
                throw new RuntimeException();
            }
        }).toList();
    }
}
