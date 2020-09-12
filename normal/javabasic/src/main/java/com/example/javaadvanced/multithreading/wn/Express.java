package com.example.javaadvanced.multithreading.wn;

/**
 * 实体类
 */
public class Express {
    public final static String CITY = "ShangHai";
    private int km; // 里程
    private String site; // 到达站点

    public Express() {}

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /**
     * 变化里程数，然后通知处于等待状态并需要处理里程数变化的线程进行业务处理
     */
    public synchronized void changeKm(int km) {
        this.km = km;
        notifyAll();
    }

    /**
     * 站点变化，然后通知处于等待状态并需要处理站点变化的线程进行业务处理
     */
    public synchronized void changeSite(String site) {
        this.site = site;
        notifyAll();
    }

    public synchronized void waitKm() {
        while (this.km < 100) {
            try {
                wait();
                System.out.println("check km thread [" + Thread.currentThread().getName() +
                        "] is notified...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("km = " + this.km + ", do something");
    }

    public synchronized void waitSite() {
        while (CITY.equals(this.site)) {
            try {
                wait();
                System.out.println("check site thread [" + Thread.currentThread().getName() +
                        "] is notified...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("site = " + this.km + ", do something");
    }
}
