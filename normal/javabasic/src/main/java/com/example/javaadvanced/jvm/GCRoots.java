package com.example.javaadvanced.jvm;

public class GCRoots {

    Object o = new Object();

    final Object gcRoot1 = new Object();
    static Object gcRoot2 = new Object();

    // 可达
    private void reachable() {
        Object object = gcRoot1;
        Object object2 = object;
        Object object3 = object;
        Object object4 = object3;
    }

    // 不可达
    private void unreachable() {
        Object object5 = o;
        Object object6 = object5;
        Object object7 = object5;
    }

}
