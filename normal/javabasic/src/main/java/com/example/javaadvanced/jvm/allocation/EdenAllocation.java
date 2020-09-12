package com.example.javaadvanced.jvm.allocation;

/**
 * 对象优先在Eden空间分配
 * JVM参数：-Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
 */
public class EdenAllocation {

    private final static int _1M = 1024 * 1024 * 1;

    public static void main(String[] args) {
        byte[] edenAlloc1, edenAlloc2, edenAlloc3, edenAlloc4;
        edenAlloc1 = new byte[_1M];
        edenAlloc2 = new byte[_1M];
        edenAlloc3 = new byte[_1M];
        edenAlloc4 = new byte[_1M];
    }

}
