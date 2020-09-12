package com.example.javaadvanced.multithreading.tools;

import java.util.concurrent.TimeUnit;

public class SleepTools {

    public static void second(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void millisecond(int millisecond) {
        try {
            TimeUnit.MILLISECONDS.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
