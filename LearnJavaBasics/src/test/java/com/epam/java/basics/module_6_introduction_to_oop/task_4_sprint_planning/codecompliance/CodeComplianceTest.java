package com.epam.java.basics.module_6_introduction_to_oop.task_4_sprint_planning.codecompliance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.AbstractFilter;

import java.util.Collection;
import java.util.List;
import java.util.stream.BaseStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeComplianceTest {

    private static CtPackage spoonRootPackage;

    @BeforeAll
    static void init() {
        final SpoonAPI spoon = new Launcher();
        spoon.addInputResource("src/main/java/");
        spoon.buildModel();
        spoonRootPackage = spoon.getFactory().Package().getRootPackage();
    }

    @Test
    void testNoCollections() {

        CtTypeReference baseCollectionRefType = new Launcher().getFactory().Code().createCtTypeReference(Collection.class);

        final List<CtInvocation> methodCallsReturningCollections = spoonRootPackage.getElements(
                new AbstractFilter<>() {
                    @Override
                    public boolean matches(final CtInvocation invocation) {
                        return invocation.getType().isSubtypeOf(baseCollectionRefType);
                    }
                }
        );
        assertEquals(0, methodCallsReturningCollections.size(),
                () -> "You must not use collections in this exercises, " +
                        "but you have supplied " + methodCallsReturningCollections.size() + " of them: "
                        + methodCallsReturningCollections);

        final List<CtVariable> collectionsVariable = spoonRootPackage.getElements(
                new AbstractFilter<>() {
                    @Override
                    public boolean matches(final CtVariable var) {
                        return var.getType().isSubtypeOf(baseCollectionRefType);
                    }
                }
        );

        assertEquals(0, collectionsVariable.size(),
                () -> "You must not use collections in this exercises, " +
                        "but you have supplied " + collectionsVariable.size() + " of them: "
                        + collectionsVariable);

    }

    @Test
    void testNoStreams() {

        CtTypeReference baseStreamRefType = new Launcher().getFactory().Code().createCtTypeReference(BaseStream.class);

        final List<CtInvocation> methodCallsReturningStreams = spoonRootPackage.getElements(
                new AbstractFilter<>() {
                    @Override
                    public boolean matches(final CtInvocation invocation) {
                        return invocation.getType().isSubtypeOf(baseStreamRefType);
                    }
                }
        );
        assertEquals(0, methodCallsReturningStreams.size(),
                () -> "You must not use streams in this exercises, " +
                        "but you have supplied " + methodCallsReturningStreams.size() + " of them: "
                        + methodCallsReturningStreams);
    }
}