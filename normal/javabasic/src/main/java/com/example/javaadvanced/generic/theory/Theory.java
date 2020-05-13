package com.example.javaadvanced.generic.theory;

import java.util.HashMap;
import java.util.Map;

public class Theory {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Samuel","25");
        System.out.println(map.get("Samuel"));
    }
}
