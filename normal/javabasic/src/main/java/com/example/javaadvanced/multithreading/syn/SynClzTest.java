package com.example.javaadvanced.multithreading.syn;

import com.example.javaadvanced.multithreading.tools.SleepTools;

public class SynClzTest {

    // 使用类锁的线程
    private static class SynClass extends Thread {

        @Override
        public void run() {
            System.out.println("Test Class is running");
            synClass();
        }
    }

    // 类锁，实际是锁类的class对象
    private static synchronized void synClass() {
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }

    private static Object object = new Object();

    private void synStaticObject() {
        synchronized(object) {// 相似于类锁，object在全虚拟机中是唯一的
            SleepTools.second(1);
            System.out.println("synClass going...");
            SleepTools.second(1);
            System.out.println("synClass end");
        }
    }

    // 使用对象锁
    private static class SynObject implements Runnable {

        private SynClzTest synClzTest;

        public SynObject(SynClzTest synClzTest) {
            this.synClzTest = synClzTest;
        }

        @Override
        public void run() {
            System.out.println("Test Instance is running - " + synClzTest);
            synClzTest.instance();
        }
    }

    // 使用对象锁
    private static class SynObject2 implements Runnable {

        private SynClzTest synClzTest;

        public SynObject2(SynClzTest synClzTest) {
            this.synClzTest = synClzTest;
        }

        @Override
        public void run() {
            System.out.println("Test Instance2 is running - " + synClzTest);
            synClzTest.instance2();
        }
    }

    // 锁对象
    private synchronized void instance() {
        SleepTools.second(3);
        System.out.println("synInstance is going..." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance ended " + this.toString());
    }

    // 锁对象
    private synchronized void instance2() {
        SleepTools.second(3);
        System.out.println("synInstance2 is going..." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 ended " + this.toString());
    }

    public static void main(String[] args) {
        SynClzTest test = new SynClzTest();
        Thread t1 = new Thread(new SynObject(test));

        SynClzTest test2 = new SynClzTest();
//        Thread t2 = new Thread(new SynObject2(test2));
        Thread t2 = new Thread(new SynObject2(test));

        t1.start();
        t2.start();

        SynClass synClass = new SynClass();
        synClass.start();
        SleepTools.second(1);
    }
}
