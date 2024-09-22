package com.epam.java.basics.module_20_collection_algorithms.task_2_maternity_hospital_journal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.fail;

public class Util {
    static String[] weekDays = {
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY",
            "SUNDAY",};

    static final String BABIES_CSV = "src/test/resources/maternity_hospital_journal/babies.csv";

    static List<Baby> getBabies(Random r, int size, String[] genders) {
        return IntStream.range(0, size).mapToObj(i -> new Baby("Baby " + r.nextInt(size),
                        round(r.nextDouble(2., 5.)),
                        r.nextInt(40, 60),
                        genders[r.nextInt(0, genders.length)],
                        r.nextInt(0, 24) + ":" + r.nextInt(0, 60)))
                .toList();
    }

    static double round(double d) {
        return Math.round(d * 10) / (double) 10;
    }

    static BirthJournalManagementImpl init(BirthJournalManagementImpl journal, int seed, WeekDay[] days, String[] genders) {
        if (seed == 0) {
            getBabiesFromCsv().forEach(e -> journal.addEntryOfBaby(e.getKey(), e.getValue()));
        }
        Random r = new Random(seed);
        getBabies(r, 24, genders).forEach(b -> journal.addEntryOfBaby(days[r.nextInt(0, days.length)], b));
        return journal;
    }

    static List<Baby> getBabiesFromString(String text) {
        return Arrays.stream(text.split(";"))
                .map(t -> t.split(","))
                .map(a -> a.length < 5 ? null : new Baby(
                        a[0].trim(),
                        Double.parseDouble(a[1]),
                        Integer.parseInt(a[2].trim()),
                        a[3].trim(),
                        a[4].trim()))
                .filter(Objects::nonNull)
                .toList();
    }

    static List<Map.Entry<WeekDay, Baby>> getBabiesFromCsv() {
        try {
            return Files.readAllLines(Paths.get(BABIES_CSV)).stream()
                    .map(s -> s.split(";"))
                    .map(a -> {
                        String[] sp = a[1].split(",");
                        return (Map.Entry<WeekDay, Baby>) new AbstractMap.SimpleEntry<>(
                                WeekDay.valueOf(weekDays[Integer.parseInt(a[0])]),
                                sp.length < 5 ? null :
                                        new Baby(sp[0].trim(),
                                                Double.parseDouble(sp[1]),
                                                Integer.parseInt(sp[2]),
                                                sp[3].trim(),
                                                sp[4].trim()));
                    }).toList();
        } catch (IOException e) {
            fail("The data file was not found: " + BABIES_CSV);
            throw new RuntimeException(e);
        }
    }
}
