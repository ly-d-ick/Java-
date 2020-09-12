package com.example.javaadvanced.multithreading.vola;

import com.example.javaadvanced.multithreading.tools.SleepTools;

public class VolatileCase {

    private static boolean ready;
//    private volatile static boolean ready;
    private static int number;

    private static class PrintThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread is running");
            while (!ready);
            System.out.println("number = " + number);
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
        SleepTools.second(1);
        number = 77;
        ready = true;
        SleepTools.second(5);
        System.out.println("over");
    }

}
