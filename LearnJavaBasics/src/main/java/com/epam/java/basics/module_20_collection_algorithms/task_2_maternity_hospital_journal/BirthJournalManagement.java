package com.epam.java.basics.module_20_collection_algorithms.task_2_maternity_hospital_journal;

import java.util.List;
import java.util.Set;

public interface BirthJournalManagement {

    /**
     * Adds an entry of the specified baby to the journal. Returns true
     * if the addition was successful, and, if not, false
     */
    boolean addEntryOfBaby(WeekDay day, Baby baby);

    /**
     * Makes the journal immutable
     */
    void commit();

    /**
     * Returns the number of babies born in a week
     */
    int amountBabies();

    /**
     * Finds the baby of the specified gender with the highest weight.
     * If there are multiple babies, sorts them alphabetically by name
     */
    List<Baby> findBabyWithHighestWeight(String gender);

    /**
     * Finds the baby of the specified gender with the smallest height.
     * If there are multiple babies, sorts them in ascending order of weight
     */
    List<Baby> findBabyWithSmallestHeight(String gender);

    /**
     * Finds а babies born in the specified period of time
     */
    Set<Baby> findBabiesByBirthTime(String from, String to);
}
