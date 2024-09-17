package com.epam.java.basics.module_16_introduction_to_collections.task_1_iterating_collections;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@AnalyzeClasses(packages = "com.epam.java.basics.module_16_introduction_to_collections.task_1_iterating_collections", importOptions = { ImportOption.DoNotIncludeTests.class })
class NewPostOfficeTest {

    private static final String SRC_TEST_RESOURCES_DECLINED_COSTS_CSV = "src/test/resources/new_post_office/declinedCosts.csv";

    @ParameterizedTest
    @MethodSource("casesAddBox")
    void testAddDeclineBox(Collection<Box> boxes, Collection<Integer> values, Collection<BigDecimal> expected, Collection<BigDecimal> declinedExpected, int percent) {
        NewPostOffice office = new NewPostOffice();
        Iterator<Integer> valuesIt = values.iterator();
        int size = 0;
        for (Box b : boxes) {
            assertTrue(office.addBox(b.getAddresser(), b.getRecipient(),
                    b.getWeight(), b.getVolume(), valuesIt.next()));
            assertEquals(++size, office.getListBox().size());
        }

        assertEquals(expected, office.getListBox().stream()
                .map(Box::getCost)
                .collect(Collectors.toList()));

        office.declineCostOfBox(percent);
        Iterator<BigDecimal> actual = office.getListBox().stream().map(Box::getCost).iterator();
        declinedExpected.forEach(e -> assertEquals(
                e.setScale(12, RoundingMode.FLOOR),
                actual.next().setScale(12, RoundingMode.FLOOR)));
    }

    @ParameterizedTest
    @MethodSource("casesDeliveryBoxToRecipient")
    void testDeliveryBoxToRecipient(Params params) {
        NewPostOffice office = new NewPostOffice();
        params.boxes.forEach(b -> office.addBox(b.getAddresser(), b.getRecipient(), b.getWeight(), b.getVolume(), 1));
        Collection<Box> deliveredBoxes = office.deliveryBoxToRecipient(params.recipient);
        Collection<Box> officeListBoxes = office.getListBox();
        assertEquals(params.deliveredBoxes, deliveredBoxes);
        assertEquals(params.officeBoxes, officeListBoxes);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/new_post_office/costs.csv", delimiterString = ",")
    void testCalculateCostOfBox(double weight, double volume, int value, BigDecimal expected) {
        assertEquals(expected, NewPostOffice.calculateCostOfBox(weight, volume, value));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/new_post_office/throws.csv", delimiterString = ",")
    void testAddShouldThrow(String addresser, String recipient, double weight, double volume, int value) {
        NewPostOffice office = new NewPostOffice();
        assertThrows(IllegalArgumentException.class, () -> office.addBox(addresser, recipient, weight, volume, value));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/new_post_office/simple.csv", delimiterString = ",")
    void testAddShouldNotThrow(String addresser, String recipient, double weight, double volume, int value) {
        NewPostOffice office = new NewPostOffice();
        assertDoesNotThrow(() -> office.addBox(addresser, recipient, weight, volume, value));
    }

    public static Stream<Arguments> casesAddBox() {
        Random r = new Random(53);
        Collection<Box> boxes = generateBoxes(r, 250);
        Collection<Integer> values = generateInts(r);
        Iterator<Integer> valuesIt = values.iterator();
        Collection<BigDecimal> expected = boxes.stream()
                .map(b -> NewPostOffice.calculateCostOfBox(b.getWeight(), b.getVolume(), valuesIt.next()))
                .toList();

        Iterator<Box> boxesIt = boxes.iterator();
        Iterator<BigDecimal> expectedIt = expected.iterator();
        Iterator<Integer> valueIt = values.iterator();

        Iterator<String> declinedExpectedIt;
        try {
            declinedExpectedIt = Files.readAllLines(Paths.get(SRC_TEST_RESOURCES_DECLINED_COSTS_CSV)).iterator();
        } catch (IOException e) {
            throw new IllegalStateException("The file '" + SRC_TEST_RESOURCES_DECLINED_COSTS_CSV + "' could not be read", e);
        }

        return Stream.iterate(0, x -> x + 1)
                .limit(5)
                .map(_ -> Arguments.of(
                                Stream.generate(boxesIt::next).limit(50).collect(Collectors.toList()),
                                Stream.generate(valueIt::next).limit(50).collect(Collectors.toList()),
                                Stream.generate(expectedIt::next).limit(50).collect(Collectors.toList()),
                                Stream.generate(declinedExpectedIt::next).limit(50)
                                        .map(BigDecimal::new)
                                        .collect(Collectors.toList()),
                                nextInt(r, 3, 10)
                        )
                );
    }

    private static List<Integer> generateInts(Random r) {
        return Stream.generate(() -> nextInt(r, 60, 500))
                .limit(250)
                .collect(Collectors.toList());
    }

    static Stream<Arguments> casesDeliveryBoxToRecipient() {
        Random r = new Random(172);

        return IntStream.range(0, 5).mapToObj(_ -> generateBoxes(r, 50))
                .map(boxes -> {
                    NewPostOffice office = new NewPostOffice();
                    boxes.forEach(b -> office.addBox(b.getAddresser(), b.getRecipient(), b.getWeight(), b.getVolume(), 1));
                    return office.getListBox();
                })
                .map(boxes -> Arguments.of(
                                new Params(
                                        boxes,
                                        boxes.stream().filter(b -> !boxes.iterator().next().getRecipient()
                                                .equalsIgnoreCase(b.getRecipient())).collect(Collectors.toList()),
                                        boxes.stream().filter(b -> boxes.iterator().next().getRecipient()
                                                .equalsIgnoreCase(b.getRecipient())).collect(Collectors.toList()),
                                        boxes.iterator().next().getRecipient()
                                )
                        )
                );
    }

    record Params(Collection<Box> boxes, Collection<Box> officeBoxes, Collection<Box> deliveredBoxes,
                  String recipient) {
    }

    private static List<Box> generateBoxes(Random r, int limit) {
        return Stream.generate(() -> new Box("Addresser" + nextInt(r, 1, 50),
                        "Recipient" + nextInt(r, 1, 50),
                        nextDouble(r, 0.5, 20.0),
                        nextDouble(r, 0.01, 0.25)))
                .limit(limit)
                .collect(Collectors.toList());
    }

    static int nextInt(Random r, int origin, int bound) {
        return r.nextInt(bound - origin) + origin;
    }

    private static double nextDouble(Random r, double origin, double bound) {
        return r.nextDouble() * (bound - origin) + origin;
    }
}