package com.example.javaadvanced.jvm.memleak;

public class Stack {

    public Object[] elements;
    private int index = 0;
    private final static int SIZE = 16;

    public Stack() {
        elements = new Object[SIZE];
    }

    public void push(Object o) {
        elements[index] = o;
        index++;
    }

    public Object pop() {
        index = index - 1;
        Object object = elements[index];
        elements[index] = null;
        return object;
    }

}
