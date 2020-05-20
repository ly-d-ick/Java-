package com.example.javaadvanced.reflection.more;

class Person {
    String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("set someone's name ");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("set someone's age ");
    }
    // 包含一个带参的构造器和一个不带参的构造器
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void privateMethod(){
        System.out.println("a private method");
    }
}
