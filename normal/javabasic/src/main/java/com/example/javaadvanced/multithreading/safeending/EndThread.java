package com.example.javaadvanced.multithreading.safeending;

public class EndThread {

    public static class  UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " interrupt flag: " + isInterrupted());
            while (!Thread.interrupted()) {
//            while (!isInterrupted()) {
//            while (true) {
                System.out.println(threadName + " is running");
                System.out.println(threadName + " looping interrupt flag: " + isInterrupted());
            }
            System.out.println(threadName + " interrupt flag: " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        endThread.sleep(5);
        endThread.interrupt();

    }

}
