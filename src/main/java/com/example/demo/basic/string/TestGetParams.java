package com.example.demo.basic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert
 */
public class TestGetParams {

    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("page", "a1");
//        Integer page = Integer.parseInt(map.get("page").toString());
//        System.out.println(page);

        Map<Integer, Long> map = new HashMap<>();
        System.out.println(map.get("a"));
        dealData(map.get("a"));
    }

    public static void dealData(long size) {
        if (size < 0) {
            return;
        }
    }
}
