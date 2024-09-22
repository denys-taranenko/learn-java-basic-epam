package com.epam.java.basics.module_20_collection_algorithms.task_2_maternity_hospital_journal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BirthJournalManagementImpl implements BirthJournalManagement {
    private Map<WeekDay, List<Baby>> journal = new HashMap<>();
    private boolean isCommit = false;

    @Override
    public boolean addEntryOfBaby(WeekDay day, Baby baby) {
        if (isCommit) {
            return false;
        }

        List<Baby> babyList = journal.getOrDefault(day, new ArrayList<>());
        babyList.add(baby);
        journal.put(day, babyList);
        return true;
    }

    @Override
    public void commit() {
        journal = Collections.unmodifiableMap(journal);
        isCommit = true;
    }

    @Override
    public int amountBabies() {
        int totalBabies = 0;
        for (List<Baby> babyList : journal.values()) {
            totalBabies += babyList.size();
        }
        return totalBabies;
    }

    @Override
    public List<Baby> findBabyWithHighestWeight(String gender) {
        List<Baby> filteredBabies = filterBabiesByGender(gender);
        if (filteredBabies.isEmpty()) {
            return Collections.emptyList();
        }

        double maxWeight = findMaxWeight(filteredBabies);
        List<Baby> babiesWithMaxWeight = filterBabiesByWeight(filteredBabies, maxWeight);
        sortBabiesByName(babiesWithMaxWeight);

        return babiesWithMaxWeight;
    }

    private List<Baby> filterBabiesByGender(String gender) {
        List<Baby> result = new ArrayList<>();
        for (List<Baby> babyList : journal.values()) {
            for (Baby baby : babyList) {
                if (baby.getGender().equalsIgnoreCase(gender)) {
                    result.add(baby);
                }
            }
        }
        return result;
    }

    private double findMaxWeight(List<Baby> babies) {
        double maxWeight = Double.MIN_VALUE;
        for (Baby baby : babies) {
            if (baby.getWeight() > maxWeight) {
                maxWeight = baby.getWeight();
            }
        }
        return maxWeight;
    }

    private List<Baby> filterBabiesByWeight(List<Baby> babies, double maxWeight) {
        List<Baby> result = new ArrayList<>();
        for (Baby baby : babies) {
            if (baby.getWeight() == maxWeight) {
                result.add(baby);
            }
        }
        return result;
    }

    private void sortBabiesByName(List<Baby> babies) {
        babies.sort(new Comparator<>() {
            @Override
            public int compare(Baby baby1, Baby baby2) {
                return baby1.getName().compareTo(baby2.getName());
            }
        });
    }

    @Override
    public List<Baby> findBabyWithSmallestHeight(String gender) {
        List<Baby> filteredBabies = filterBabiesByGender(gender);
        if (filteredBabies.isEmpty()) {
            return Collections.emptyList();
        }

        double minHeight = findMinHeight(filteredBabies);
        List<Baby> babiesWithMinHeight = filterBabiesByHeight(filteredBabies, minHeight);
        sortBabiesByWeight(babiesWithMinHeight);

        return Collections.unmodifiableList(babiesWithMinHeight);
    }

    private double findMinHeight(List<Baby> babies) {
        double minHeight = Double.MAX_VALUE;
        for (Baby baby : babies) {
            if (baby.getHeight() < minHeight) {
                minHeight = baby.getHeight();
            }
        }
        return minHeight;
    }

    private List<Baby> filterBabiesByHeight(List<Baby> babies, double minHeight) {
        List<Baby> result = new ArrayList<>();
        for (Baby baby : babies) {
            if (baby.getHeight() == minHeight) {
                result.add(baby);
            }
        }
        return result;
    }

    private void sortBabiesByWeight(List<Baby> babies) {
        babies.sort(new Comparator<>() {
            @Override
            public int compare(Baby baby1, Baby baby2) {
                return Double.compare(baby1.getWeight(), baby2.getWeight());
            }
        });
    }

    @Override
    public Set<Baby> findBabiesByBirthTime(String from, String to) {
        Set<Baby> result = new HashSet<>();
        for (List<Baby> babyList : journal.values()) {
            for (Baby baby : babyList) {
                if (isTimeInRange(baby.getTime(), from, to)) {
                    result.add(baby);
                }
            }
        }
        return result;
    }

    private boolean isTimeInRange(String time, String from, String to) {
        String formattedTime = formatTime(time);
        String formattedFrom = formatTime(from);
        String formattedTo = formatTime(to);
        return formattedTime.compareTo(formattedFrom) >= 0 && formattedTime.compareTo(formattedTo) <= 0;
    }

    private String formatTime(String time) {
        String[] parts = time.split(":");
        String hour = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
        String minute = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        return hour + ":" + minute;
    }
}
