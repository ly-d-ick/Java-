package com.example.javaadvanced.reflection;

/**
 * 演示反射的说明
 */
public class RefleDemo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 实例化对象的标准用法
        Servant servant = new Servant();
        servant.service("栞");

        Class servantClass = Servant.class;
        Class servantClass2 = servant.getClass();
        Class servantClass3 = Class.forName("com.example.javaadvanced.reflection.Servant");

        Servant servant1 = (Servant) servantClass3.newInstance();
        servant1.service("哈哈剑");
    }
}
