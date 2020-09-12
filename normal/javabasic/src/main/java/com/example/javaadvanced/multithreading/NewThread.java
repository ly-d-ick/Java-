package com.example.javaadvanced.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的两种方法
 */
public class NewThread {

    /* 1.扩展一个Thread类，重写run方法，再调用start方法就绪启动 */
    public static class UseThread extends Thread {
        @Override
        public void run() {
            super.run();
            // do sth
            System.out.println("I am UseThread.");
        }
    }

    /* 2.实现Runnable或Callable接口，把接口实例交给线程执行 */
    public static class UseRun implements Runnable {

        @Override
        public void run() {
            System.out.println("I am UseRun.");
        }
    }

    public static class UseCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("I am UseCall.");
            return "OK";
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new UseThread().start();

        new Thread(new UseRun()).start();

        FutureTask<String> task = new FutureTask<>(new UseCall());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
