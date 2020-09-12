package com.example.javaadvanced.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private int count = 0;

    private Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

}
