package com.example.javaadvanced.jvm;

import com.example.javaadvanced.multithreading.tools.SleepTools;

import java.util.LinkedList;
import java.util.List;

/**
 * -Xms20m -Xms20m -Xmn10 -XX:+UseGCDetails
 */
public class StopWorld {

    /**
     * 模拟业务线程，填充数据
     */
    private static class WorkThrad extends Thread {

        List<byte[]> list = new LinkedList<>();

        @Override
        public void run() {
            while (true) {
                if (list.size() * 512 / 1024 / 1024 >= 990) {
                    list.clear();
                    System.out.println("finishing clearing");
                }
                byte[] bytes;
                for (int i = 0; i < 100; i++) {
                    bytes = new byte[512];
                    list.add(bytes);
                }
                SleepTools.millisecond(1);
            }
        }
    }

    /**
     * 定时输出日志
     */
    private static class LogThread extends Thread {

        long start = System.currentTimeMillis();

        @Override
        public void run() {
            while (true) {
                long print = System.currentTimeMillis() - start;
                System.out.println(print / 1000 + "." + print % 1000);
                SleepTools.millisecond(100);
            }
        }
    }

    public static void main(String[] args) {
        new WorkThrad().start();
        new LogThread().start();
    }

}
