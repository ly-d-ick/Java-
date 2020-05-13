package com.example.javaadvanced.generic.defgeneric;

public class NormalGeneric2<T, K> {

    private T data;
    private K result;

    public NormalGeneric2() {
    }

    public NormalGeneric2(T data) {
        this();
        this.data = data;
    }
}
