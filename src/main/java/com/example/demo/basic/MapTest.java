package com.example.demo.basic;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author robert
 */
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        Map map = new HashMap();
        map.put(null, null);
        System.out.println(map.toString());

        Arrays.asList(1,2);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("");
        List list = new ArrayList();
    }
}
