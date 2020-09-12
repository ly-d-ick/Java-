package com.example.javaadvanced.multithreading.threadpool;

import com.example.javaadvanced.multithreading.tools.SleepTools;

import java.util.Random;

public class TestThreadPool {

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(3, 0);
        pool.execute(new TestTask("test 1"));
        pool.execute(new TestTask("test 2"));
        pool.execute(new TestTask("test 3"));
        pool.execute(new TestTask("test 4"));
        pool.execute(new TestTask("test 5"));
        System.out.println(pool);
        SleepTools.second(10);
        pool.destroy();
        System.out.println(pool);

    }

    private static class TestTask implements Runnable {

        private String name;
        private Random random = new Random();

        public TestTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(1000) + 2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId() + "sleep Interrupted Exception: " +
                        Thread.currentThread().isInterrupted());
            }
            System.out.println("任务" + name + "完成");
        }
    }

}
