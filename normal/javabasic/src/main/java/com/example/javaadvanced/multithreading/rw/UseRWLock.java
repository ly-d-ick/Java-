package com.example.javaadvanced.multithreading.rw;

import com.example.javaadvanced.multithreading.tools.SleepTools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseRWLock implements GoodsService {

    private GoodsInfo goodsInfo;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock getLock = lock.readLock();
    private final Lock setLock = lock.writeLock();

    public UseRWLock(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public GoodsInfo getNum() {
        getLock.lock();
        try {
            SleepTools.millisecond(5);
            return this.goodsInfo;
        } finally {
            getLock.unlock();
        }
    }

    @Override
    public void setNum(int number) {
        setLock.lock();
        try {
            SleepTools.millisecond(5);
            goodsInfo.changeNumber(number);
        } finally {
            setLock.unlock();
        }
    }
}
