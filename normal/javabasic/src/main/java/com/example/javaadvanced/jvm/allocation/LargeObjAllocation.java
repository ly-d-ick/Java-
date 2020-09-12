package com.example.javaadvanced.jvm.allocation;

/**
 * 大对象直接进入老年代
 * JVM参数：-Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=2
 */
public class LargeObjAllocation {
    private final static int _1M = 1024 * 1024 * 1;

    public static void main(String[] args) {
        byte[] edenAlloc, LargeAlloc;
        edenAlloc = new byte[3 * _1M];
        LargeAlloc = new byte[5 * _1M];
    }
}
