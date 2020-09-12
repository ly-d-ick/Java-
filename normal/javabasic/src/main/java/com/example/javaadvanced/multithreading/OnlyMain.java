package com.example.javaadvanced.multithreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class OnlyMain {
    public static void main(String[] args) {
        // 类ManagementFactory是对虚拟机相关部分管理、监控的工厂类
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        /* 获取线程信息 */
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info: threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + " " + info.getThreadName());
        }
    }
}
