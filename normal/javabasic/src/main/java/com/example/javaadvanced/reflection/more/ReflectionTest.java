package com.example.javaadvanced.reflection.more;

public class ReflectionTest {

    public static void main(String[] args) throws Exception {
        TestClassLoader.testClassLoader();
        TestConstructor.testConstructor();
        TestMethod.testMethod();
        TestField.testField();
    }
}
