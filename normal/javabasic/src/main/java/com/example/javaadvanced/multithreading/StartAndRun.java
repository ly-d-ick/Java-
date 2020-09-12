package com.example.javaadvanced.multithreading;

/**
 * Thread#start()和Thread#run()的区别
 */
public class StartAndRun {

    public static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 50;
            try {
                while (i > 0) {
                    sleep(1000);
                    System.out.println("I am " + Thread.currentThread().getName() + " and i = " + i--);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class User {
        public void setName() {

        }
    }

    public static void main(String[] args) {
        ThreadRun running = new ThreadRun();
        running.setName("running thread");
//        running.run();

        new User().setName();

        running.start();

    }

}
