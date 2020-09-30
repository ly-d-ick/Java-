package com.example.javaadvanced.jvm;

import java.util.LinkedList;
import java.util.List;

public class OOM {

    public static void main(String[] args) {
        List<Object> list= new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 10000 == 0) {
                System.out.println("i = " + i);
                list.add(new Object());
                System.out.println("test");
            }
        }
    }

}
