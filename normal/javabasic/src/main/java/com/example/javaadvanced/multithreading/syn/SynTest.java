package com.example.javaadvanced.multithreading.syn;

public class SynTest {

    private long count = 0;
    private Object object = new Object();

    // 对象锁 - 用于对象实例方法
    public synchronized void incCount() {
        count++;
    }

    // 对象锁 - 用于一个对象实例上
    public void incCount2() {
        synchronized (object) {
            count++;
        }
    }

    // 对象锁 - 用于一个对象实例上
    public void incCount3() {
        synchronized (this) {
            count++;
        }
    }

    private static class Count extends Thread {

        private SynTest test;

        public Count(SynTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
//                test.incCount();
//                test.incCount2();
                test.incCount3();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest test = new SynTest();
        Count count1 = new Count(test);
        Count count2 = new Count(test);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(test.count);
    }
}
