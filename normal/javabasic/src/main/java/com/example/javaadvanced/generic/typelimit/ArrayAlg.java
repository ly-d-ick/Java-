package com.example.javaadvanced.generic.typelimit;

import java.util.ArrayList;

public class ArrayAlg {
//    public static <T> T min(T a,T b){
//        if(a.compareTo(b)>0) return a; else return b;
//    }

    public static <T extends ArrayList & Comparable> T min(T a, T b){
        if(a.compareTo(b)>0) return a; else return b;
    }

    static class Test extends ArrayList<Integer> implements Comparable {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayAlg.min(new Test(),new Test());
    }
}
