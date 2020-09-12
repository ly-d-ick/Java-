package com.example.javaadvanced.multithreading.condition;

import com.example.javaadvanced.multithreading.tools.SleepTools;

public class Test_Condition {
    private static Express_Condition express = new Express_Condition(0, Express_Condition.CITY);

    /**
     * 检查里程数变化的线程,不满足条件，线程一直等待
     */
    private static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitKm();
        }
    }

    /**
     * 检查站点变化的线程,不满足条件，线程一直等待
     */
    private static class CheckSite extends Thread {
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckSite().start();
        }
        SleepTools.second(1);
        express.changeKm(223);
    }
}
