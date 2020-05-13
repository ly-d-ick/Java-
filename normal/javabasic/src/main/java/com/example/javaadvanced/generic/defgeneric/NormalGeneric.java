package com.example.javaadvanced.generic.defgeneric;

public class NormalGeneric<T> {

    private T data;

    public NormalGeneric() {
    }

    public NormalGeneric(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        NormalGeneric<String> normalGeneric = new NormalGeneric<>();
        normalGeneric.setData("OK");
        System.out.println(normalGeneric.getData());
    }
}
