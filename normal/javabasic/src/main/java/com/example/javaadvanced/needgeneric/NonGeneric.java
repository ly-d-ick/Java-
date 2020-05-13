package com.example.javaadvanced.needgeneric;

public class NonGeneric {

    public int addInt(int x, int y) {
        return x + y;
    }

    public float addFloat(float x, float y) {
        return x + y;
    }

    public static void main(String[] args) {
        NonGeneric generic = new NonGeneric();
        System.out.println(generic.addInt(1, 2));
        System.out.println(generic.addFloat(1F, 2F));
    }
}
