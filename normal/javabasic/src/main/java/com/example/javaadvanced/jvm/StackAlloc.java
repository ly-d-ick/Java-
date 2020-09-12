package com.example.javaadvanced.jvm;

public class StackAlloc {

    public static class User {
        public static int id;
        public static String name;
    }

    public static void alloc() {
        User user = new User();
        user.id = 35;
        user.name = "Kurts";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            alloc();
        }
        System.out.println((System.currentTimeMillis() - start) + "毫秒");
    }

}
