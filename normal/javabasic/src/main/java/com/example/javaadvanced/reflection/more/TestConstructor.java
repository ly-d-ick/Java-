package com.example.javaadvanced.reflection.more;

import java.lang.reflect.Constructor;

public class TestConstructor {
    /* 构造器 */
    public static void testConstructor() throws Exception {
        String className = "com.example.javaadvanced.reflection.more.Person";
        Class<Person> clz = (Class<Person>) Class.forName(className);

        System.out.println("获取Constructor对象：");
        Constructor<Person>[] constructors = (Constructor<Person>[]) clz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("获取某一个Constructor对象，需参数列表：");
        Constructor<Person> constructor = clz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        /**
         * 初始化对象的三种方法
         * 1、普通初始化
         * 2、拿到类的class对象，然后调用newInstance()
         * 3、通过反射拿到构造器，再调用构造器#newInstance()创建对象，代码如下
          */
        System.out.println("调用构造器#newInstance()创建对象：");
        Person person = constructor.newInstance("Samuel", 999);
        System.out.println(person.getName() + ", " + person.getAge());
    }
}
