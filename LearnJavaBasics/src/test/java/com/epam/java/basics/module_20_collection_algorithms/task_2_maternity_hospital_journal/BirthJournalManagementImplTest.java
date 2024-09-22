package com.epam.java.basics.module_20_collection_algorithms.task_2_maternity_hospital_journal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.*;
import java.util.stream.IntStream;

import static com.epam.java.basics.module_20_collection_algorithms.task_2_maternity_hospital_journal.Util.*;
import static org.junit.jupiter.api.Assertions.*;

class BirthJournalManagementImplTest {
    private static final String[] GENDERS = {"male", "female"};
    Baby emptyBaby = new Baby("", 0., 0, "", ":");
    Baby baby1;
    Baby baby2;
    List<Baby> goodBabies;
//    WeekDay[] weekDays = new WeekDay[] {new WeekDay(), new WeekDay(), new WeekDay(), new WeekDay(), new WeekDay(), new WeekDay(), new WeekDay(), };

    @BeforeEach
    void setUp() {
        goodBabies = getBabies(new Random(15), 5, GENDERS);
        baby1 = goodBabies.get(0);
        baby2 = goodBabies.get(1);
    }

    @Test
    void testAmountBabies() {
        BirthJournalManagement journal =
                init(new BirthJournalManagementImpl(), 5,
                        WeekDay.values(), GENDERS);
        assertEquals(24, journal.amountBabies(),
                "");
        assertEquals(0, new BirthJournalManagementImpl().amountBabies(),
                "");
    }

    @Test
    void testAddEntryOfBaby() {
        List<Baby> babies = getBabies(new Random(10), 24, GENDERS);
        Iterator<Baby> it = babies.iterator();
        BirthJournalManagementImpl journal = new BirthJournalManagementImpl();

        IntStream.range(0, 24).forEach(b ->
                assertTrue(journal.addEntryOfBaby(WeekDay.valueOf("FRIDAY"), it.next()),
                        ""));

        journal.commit();
        assertFalse(journal.addEntryOfBaby(WeekDay.valueOf("FRIDAY"), emptyBaby),
                "");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/maternity_hospital_journal/babies-weight.csv", delimiter = ';')
    void testFindBabyWithHighestWeight(int r, String gender, String babyString) {
        BirthJournalManagementImpl journal =
                init(new BirthJournalManagementImpl(), r,
                        WeekDay.values(), GENDERS);

        List<Baby> actual = journal.findBabyWithHighestWeight(gender);
        List<Baby> expected = getBabiesFromString(babyString);
        assertIterableEquals(expected, actual,
                "");
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/maternity_hospital_journal/babies-height.csv"}, delimiter = ';')
    void testFindBabyWithSmallestHeight(int r, String gender, String babyString) {
        BirthJournalManagementImpl journal =
                init(new BirthJournalManagementImpl(), r,
                        WeekDay.values(), GENDERS);

        List<Baby> actual = journal.findBabyWithSmallestHeight(gender);
        List<Baby> expected = getBabiesFromString(babyString);
        assertIterableEquals(expected, actual, "");

        ListIterator<Baby> it = actual.listIterator();
        if (it.hasNext()) it.next();
        assertThrows(UnsupportedOperationException.class, () -> it.set(baby1),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.add(baby1),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.addFirst(baby1),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.addAll(List.of(baby1, baby2)),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.remove(baby1),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.removeAll(List.of(baby1, baby2)),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.replaceAll(e -> e),
                "The returned list must be unmodifiable");
        assertThrows(UnsupportedOperationException.class, () -> actual.sort(Comparator.comparing(Baby::getGender)),
                "The returned list must be unmodifiable");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/maternity_hospital_journal/babies-times.csv", delimiter = ';')
    void testFindBabiesByBirthTime(int r, String from, String to, String babyString) {
        BirthJournalManagement journal = init(new BirthJournalManagementImpl(), r,
                WeekDay.values(), GENDERS);

        Set<Baby> actual = journal.findBabiesByBirthTime(from, to);
        List<Baby> expected = getBabiesFromString(babyString);
        assertIterableEqualsIgnoreOrdering(expected, actual,
                "\nExpected: " + expected + "\n but was: " + actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/maternity_hospital_journal/babies-times2.csv", delimiter = ';')
    void testFindBabiesByBirthTime2(int r, String from, String to, String babyString) {
        BirthJournalManagementImpl journal =
                init(new BirthJournalManagementImpl(), r,
                        WeekDay.values(), GENDERS);

        Set<Baby> actual = journal.findBabiesByBirthTime(from, to);
        List<Baby> expected = getBabiesFromString(babyString);
        assertIterableEqualsIgnoreOrdering(expected, actual,
                "\nExpected: " + expected + "\n but was: " + actual);
    }

    private void assertIterableEqualsIgnoreOrdering(List<Baby> expected, Set<Baby> actual, String message) {
        assertEquals(expected.size(), actual.size(),
                "The size of iterables are differ, " +
                        "expected: " + expected.size() + ", but was: " + actual.size() +
                        " ==> " + message);

        assertTrue(expected.containsAll(actual), "The iterables are differ, " +
                "expected: " + expected + ", but was: " + actual + " ==> " + message);
        assertTrue(actual.containsAll(expected), "The iterables are differ, " +
                "expected: " + expected + ", but was: " + actual + " ==> " + message);
    }
}
