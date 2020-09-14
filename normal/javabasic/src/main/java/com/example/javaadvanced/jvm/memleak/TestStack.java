package com.example.javaadvanced.jvm.memleak;

public class TestStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Object object1 = new Object();
        stack.push(object1);
        Object object2 = stack.pop();
        System.out.println("object2 = " + object2);
        System.out.println("element = " + stack.elements[0]);
    }

}
