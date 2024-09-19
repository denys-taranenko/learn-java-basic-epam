package com.epam.java.basics.module_18_sets.task_1_ranged_ops_integer_set;

import org.junit.jupiter.api.Test;

import java.util.AbstractSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeComplianceTests {

    @Test
    void testAncestor() {
        assertEquals(AbstractSet.class, RangedOpsIntegerSet.class.getSuperclass());
    }
}
