package com.example.javaadvanced.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * JVM参数：-Xmx10m -Xms10m -XX:+PrintGC
 */
public class Reference {
    public static void main(String[] args) {
//        testSoftReference();
//        testWeakReference();
        try {
            testPhantomference();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testSoftReference() {
        User user = new User("11", 11);
        SoftReference<User> userSoft = new SoftReference<User>(user);
        user = null; // 回收强引用，确保栈中只有软引用对象
        System.out.println(userSoft.get());
        System.gc();
        System.out.println("After gc");
        System.out.println(userSoft.get());

        LinkedList<byte[]> list = new LinkedList<>();
        try {
            for (int i = 0; i < 100; i++){
                System.out.println("for ============= " + userSoft.get());
                list.add(new byte[1024 * 1024 * 1]);
            }
        } catch (Throwable e) {
            System.out.println("Exception ============= " + userSoft.get());
        }

    }

    public static void testWeakReference() {
        User user = new User("22", 22);
        WeakReference<User> weakReference = new WeakReference<>(user);
        user = null;
        System.out.println(weakReference.get());
        System.gc();
        System.out.println("After gc");
        System.out.println(weakReference.get());
    }

    public static void testPhantomference() throws InterruptedException {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Object phantomObject = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObject, referenceQueue);
        phantomObject = null;
        System.out.println("phantomObject: " + phantomObject);
        System.out.println("referenceQueue: " + referenceQueue.poll());
        System.gc();
        Thread.sleep(2000);
        System.out.println("referenceQueue: " + referenceQueue.poll());
    }

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
