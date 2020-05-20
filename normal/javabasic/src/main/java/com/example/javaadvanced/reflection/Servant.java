package com.example.javaadvanced.reflection;

import androidx.annotation.NonNull;

public class Servant {

    public boolean service (String message) {
        System.out.println("测试服务类：" + message);
        return true;
    }

    @NonNull
    @Override
    public String toString() {
        return "Hello World!~~";
    }
}
