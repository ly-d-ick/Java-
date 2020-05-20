package com.example.javaadvanced.reflection.more;

import java.io.FileNotFoundException;

public class TestClassLoader {
    /* 类加载器相关 */
    public static void testClassLoader() throws ClassNotFoundException, FileNotFoundException {

        // 1.获取系统的类加载器(可以获取，当前这个类TestClassLoader就是它加载的)
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        // 2.获取系统类加载器的父类加载器(扩展类加载器，可以获取)
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

        // 3.获取扩展类加载器的父类加载器(引导类加载器，不可获取)
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

        // 4.测试当前类有哪个类加载器进行加载(系统类加载器)
        classLoader = Class.forName("com.example.javaadvanced.reflection.more.ReflectionTest")
                .getClassLoader();
        System.out.println(classLoader);

        // 5.测试JDK提供的Object类有哪个类加载器负责加载(引导类)
        classLoader = Class.forName("java.lang.Object")
                .getClassLoader();
        System.out.println(classLoader);
    }
}
