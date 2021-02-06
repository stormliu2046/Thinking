package com.example.demo.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert
 */
@Slf4j
public class CollectionTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("test" + i);
        }
        log.info(list.toString());
        for (int i = 0; i < list.size(); i++) {
            if ("test2".equals(list.get(i))) {
                list.remove(i);
            }
        }
        log.info(list.toString());
    }
}

class TestArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("test" + i);
        }
        System.out.println(list.subList(3, 5));
    }
}
