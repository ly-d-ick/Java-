package com.example.javaadvanced.reflection.more;

import java.lang.reflect.Field;

public class TestField {
    /* 域 */
    public static void testField() throws Exception {
        Class clz = Class.forName("com.example.javaadvanced.reflection.more.Person");

        System.out.println(" ");
        System.out.println("获取当前类的所有字段");
        Field[] fields = clz.getDeclaredFields();
        for (Field field: fields) {
            System.out.print(field.getName() + " ");
        }
        System.out.println();
        System.out.println("---------------------------");

        System.out.println("获取指定字段");
        Field field = clz.getDeclaredField("name");
        System.out.println(field.getName());

        Person person = (Person) clz.getConstructor(String.class, int.class).newInstance("Cris", 888);
        System.out.println("获取指定字段的值");
        Object object = field.get(person);
        System.out.println(field.getName() + " = " + object);

        System.out.println("获取私有字段，须先调用setAccessible(true)");
        field = clz.getDeclaredField("age");
        field.setAccessible(true);
        object = field.get(person);
        System.out.println(field.getName() + " = " + object);
    }

}
