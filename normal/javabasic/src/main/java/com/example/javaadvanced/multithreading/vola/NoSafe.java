package com.example.javaadvanced.multithreading.vola;

public class NoSafe {

    private volatile long count = 0;

    public void incCount() {
        count++;
    }

    private static class Count extends Thread {

        private NoSafe test;

        public Count(NoSafe test) {
            this.test = test;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                test.incCount();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NoSafe test = new NoSafe();
        NoSafe.Count count1 = new NoSafe.Count(test);
        NoSafe.Count count2 = new NoSafe.Count(test);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(test.count);
    }

}
