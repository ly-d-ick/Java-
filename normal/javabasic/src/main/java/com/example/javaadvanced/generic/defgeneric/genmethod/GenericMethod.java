package com.example.javaadvanced.generic.defgeneric.genmethod;

public class GenericMethod {

    public <T> T genericMethod(T...a)  {
        return a[a.length / 2];
    }

    public void text(int x, int y) {
        System.out.println(x + y);
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.text(23, 343);
        System.out.println(genericMethod.<String>genericMethod("Samuel", "Ok", "Horo"));
        System.out.println(genericMethod.genericMethod(12, "int", 44));
    }
}
