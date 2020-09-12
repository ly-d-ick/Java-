package com.example.javaadvanced.multithreading.threadlocal;

public class UseThreadLocal {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public void startThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new UseThreadLocal.TestTask(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static class TestTask implements Runnable {

        int id;

        public TestTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": start");
            Integer count = threadLocal.get();
            count = id + count;
            threadLocal.set(count);
            System.out.println(Thread.currentThread().getName() + ": count = " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal test = new UseThreadLocal();
        test.startThreadArray();
    }
}
