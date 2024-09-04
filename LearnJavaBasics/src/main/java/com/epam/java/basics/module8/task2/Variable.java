package com.epam.java.basics.module8.task2;

public class Variable implements Expression {
    private final String name;
    private int value;

    public Variable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toExpressionString() {
        return name;
    }
}