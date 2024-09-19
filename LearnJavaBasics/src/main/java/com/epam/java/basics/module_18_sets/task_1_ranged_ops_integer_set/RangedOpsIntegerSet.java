package com.epam.java.basics.module_18_sets.task_1_ranged_ops_integer_set;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class RangedOpsIntegerSet extends AbstractSet<Integer> {
    private final Set<Integer> resultSet;

    public RangedOpsIntegerSet() {
        this.resultSet = new TreeSet<>();
    }

    public boolean add(int fromInclusive, int toExclusive) {
        int startSize = resultSet.size();
       for (int i = fromInclusive; i < toExclusive; i++) {
            resultSet.add(i);
        }
        return startSize < resultSet.size();
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        int startSize = resultSet.size();
        for (int i = fromInclusive; i < toExclusive; i++) {
            resultSet.remove(i);
        }
        return startSize > resultSet.size();
    }

    @Override
    public boolean add(final Integer integer) {
        return resultSet.add(integer);
    }

    @Override
    public boolean remove(final Object o) {
        return resultSet.remove(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return resultSet.iterator();
    }

    @Override
    public int size() {
        return resultSet.size();
    }
}
