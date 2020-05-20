package com.example.javaadvanced.reflection.more;

import java.lang.reflect.Method;

public class TestMethod {
    /* 方法 */
    public static void testMethod() throws Exception {
        Class clz = Class.forName("com.example.javaadvanced.reflection.more.Person");

        System.out.println(" ");
        System.out.println("获取clz对应类中的所有方法，包括父类的方法，不能获取private方法。");
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "() ");
        }
        System.out.println(" ");
        System.out.println("--------------------------------------");

        System.out.println("获取当前类的所有方法");
        methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "() ");
        }
        System.out.println(" ");
        System.out.println("--------------------------------------");

        System.out.println("获取指定方法，有参需带参数类型和参数列表，无参不需要写");
        Method method = clz.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        System.out.println("--------------------------------------");

        /* Pserson#setAge的形参类型为int，用于反射，获取方法的参数写成int.class;
         * 或把int类型改为Integer*/
        method = clz.getDeclaredMethod("setAge", int.class);
        System.out.println(method);
        System.out.println("--------------------------------------");

        System.out.println("调用方法，第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数");
        Object object = clz.newInstance();
        method.invoke(object, 999);

        /* 调用私有方法，在调用invoke方法前必须加上setAccessible(true) */
        method = clz.getDeclaredMethod("privateMethod");
        System.out.println(method);
        System.out.println("--------------------------------------");
        System.out.println("调用私有方法");
        method.setAccessible(true);
        method.invoke(object);
    }

}
