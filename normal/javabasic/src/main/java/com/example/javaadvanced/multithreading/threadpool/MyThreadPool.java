package com.example.javaadvanced.multithreading.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    private final BlockingQueue<Runnable> taskQueue; // 阻塞队列
    private WorkThread[] workThreads; // 工作线程组

    private static int WORK_RUN = 5; // 线程池中默认线程数
    private static int MAX_TASK = 100; // 队列默认任务数

    private final int workingNum; // 工作线程启动数

    public MyThreadPool() {
        this(WORK_RUN, MAX_TASK);
    }

    /**
     * 创建线程池
     *
     * @param workingNum 线程池默认线程数
     * @param taskCount  阻塞队列默认任务数
     */
    public MyThreadPool(int workingNum, int taskCount) {
        if (workingNum <= 0) {
            workingNum = WORK_RUN;
        }
        if (taskCount <= 0) {
            taskCount = MAX_TASK;
        }
        this.workingNum = workingNum;
        taskQueue = new ArrayBlockingQueue<>(taskCount);
        workThreads = new WorkThread[workingNum];
        for (int i = 0; i < workingNum; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
        // 查看当前系统可用核心数
        Runtime.getRuntime().availableProcessors();
    }

    /**
     * 执行任务，将任务放进任务队列
     */
    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁线程池
     */
    public void destroy() {
        System.out.println("ready to close pool.....");
        // 停止工作线程
        for (int i = 0; i < workingNum; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        taskQueue.clear();
    }

    /**
     * 工作线程
     */
    private class WorkThread extends Thread {
        @Override
        public void run() {
            Runnable task = null;
            try {
                while (!isInterrupted()) {
                    task = taskQueue.take();
                    if (task != null) {
                        System.out.println(getId() + " ready to execute " + task);
                        task.run();
                    }
                    task = null;
                }
            } catch (Exception e) {
                // TODO: handle exception
//                e.printStackTrace();
            }
        }

        public void stopWorker() {
            interrupt();
        }
    }
}
