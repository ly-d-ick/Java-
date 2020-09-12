package com.example.javaadvanced.multithreading.safeending;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  抛出InterruptedException异常后，中断标志位改变，需要在捕获异常再次调用interrupt()来中止线程
 */
public class HasInterruptException {

    private static SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss_SSS");

    public static void main(String[] args) throws InterruptedException {
        Thread useThread = new UseThread("HasInterruptException");
        useThread.start();
        System.out.println("Main: " + format.format(new Date()));
        Thread.sleep(500);
        System.out.println("Main begin interrupt thread: " + format.format(new Date()));
        useThread.interrupt();
    }

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                try {
                    System.out.println("UseThread: " + format.format(new Date()));
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(threadName + "catch interrupt flag is " + isInterrupted() + " at "
                            + format.format(new Date()));
                    // TODO 抛出InterruptedException异常后，中断标志位改变（与调用Thread#interrupted的结果相同），需要在捕获异常再次调用interrupt()来中止线程
//                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName + " interrput flag is "
                    + isInterrupted());
        }
    }

}
