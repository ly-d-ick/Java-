package com.example.javaadvanced.multithreading.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Express_Condition {
    public final static String CITY = "ShangHai";
    private int km; // 里程
    private String site; // 到达站点
    private Lock lock = new ReentrantLock();
    private Condition kmCondition = lock.newCondition();
    private Condition siteCondition = lock.newCondition();

    public Express_Condition() {}

    public Express_Condition(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /**
     * 变化里程数，然后通知处于等待状态并需要处理里程数变化的线程进行业务处理
     */
    public void changeKm(int km) {
        lock.lock();
        try {
            this.km = km;
//            kmCondition.signalAll();
            kmCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 站点变化，然后通知处于等待状态并需要处理站点变化的线程进行业务处理
     */
    public void changeSite(String site) {
        lock.lock();
        try {
            this.site = site;
//            siteCondition.signalAll();
            siteCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void waitKm() {
        while (this.km < 100) {
            lock.lock();
            try {
                kmCondition.await();
                System.out.println("check km thread [" + Thread.currentThread().getName() +
                        "] is notified...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        System.out.println("km = " + this.km + ", do something");
    }

    public void waitSite() {
        while (CITY.equals(this.site)) {
            lock.lock();
            try {
                siteCondition.await();
                System.out.println("check site thread [" + Thread.currentThread().getName() +
                        "] is notified...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        System.out.println("site = " + this.km + ", do something");
    }
}
