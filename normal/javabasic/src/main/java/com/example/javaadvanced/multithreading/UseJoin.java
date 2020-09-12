package com.example.javaadvanced.multithreading;

/**
 * Thead#join()使用
 */
public class UseJoin {

    static class JumpQueue implements Runnable {

        private Thread thread; // 插队线程

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                System.out.println(thread.getName() + " will be join before " + Thread.currentThread().getName());
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminted");
        }
    }

    public static void main(String[] args) {
        Thread previous = Thread.currentThread(); // 主线程
        // i = 0，previous是主线程，i = 1，previous是i = 0这个线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }
}
