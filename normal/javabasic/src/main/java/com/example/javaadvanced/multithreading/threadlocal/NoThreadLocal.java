package com.example.javaadvanced.multithreading.threadlocal;

public class NoThreadLocal {

    static Integer count = new Integer(1);

    public void startThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestTask(i));
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
            count = count + id;
            System.out.println(Thread.currentThread().getName() + ", count = " + count);
        }
    }

    public static void main(String[] args) {
        NoThreadLocal test = new NoThreadLocal();
        test.startThreadArray();
    }

}
