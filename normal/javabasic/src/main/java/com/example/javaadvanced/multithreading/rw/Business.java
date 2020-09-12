package com.example.javaadvanced.multithreading.rw;

import com.example.javaadvanced.multithreading.tools.SleepTools;

import java.util.Random;

/**
 * 对商品进行业务处理
 */
public class Business {
    static final int readWriteRatio = 10; // 读写线程比例
    static final int minThreadCounts = 3; // 最少线程数

    /**
     * 读操作
     */
    private static class GetThread implements Runnable {

        private GoodsService goodsService;

        public GetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName()
                    + "读取商品数据耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
    }

    /**
     * 写操作
     */
    private static class SetThread implements Runnable {

        private GoodsService goodsService;

        public SetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                SleepTools.millisecond(50);
                goodsService.setNum(random.nextInt(10));
            }
            System.out.println(Thread.currentThread().getName()
                    + "写商品数据耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
    }

    public static void main(String[] args) {
        GoodsInfo goodsInfo = new GoodsInfo("Book", 100000, 10000);
//        GoodsService goodsService = new UseSyn(goodsInfo);
        GoodsService goodsService = new UseRWLock(goodsInfo);
        for (int i = 0; i < minThreadCounts; i++) {
            Thread setT = new Thread(new SetThread(goodsService));
            for (int j = 0; j < readWriteRatio; j++) {
                Thread getT = new Thread(new GetThread(goodsService));
                getT.start();
            }
            SleepTools.millisecond(50);
            setT.start();
        }
    }

}
