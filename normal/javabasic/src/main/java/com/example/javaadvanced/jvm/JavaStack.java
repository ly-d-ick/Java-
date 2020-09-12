package com.example.javaadvanced.jvm;

public class JavaStack {

    static String title = "月下独酌";
    final String CONSTANT = "举杯邀明月，对饮成三人";
    private int count = 0; // 计数器

    // 递减
    public void decreaseProgress(int number) {
        Object object = new Object();
        object.hashCode();

        number = number - 10;
        count++;
        decreaseProgress(number);
    }

    public static void main(String[] args) {
        JavaStack stack = new JavaStack();
        try {
            stack.decreaseProgress(820);
        } catch (Throwable throwable) {
            System.out.println("异常，当前调用次数：" + stack.count);
            throw throwable;
        }
    }
}
