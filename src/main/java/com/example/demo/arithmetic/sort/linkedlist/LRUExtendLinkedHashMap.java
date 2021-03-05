package com.example.demo.arithmetic.sort.linkedlist;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author robert
 */
@Slf4j
public class LRUExtendLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUExtendLinkedHashMap(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > LRUExtendLinkedHashMap.this.cacheSize;
    }

    public static void main(String[] args) {
        LRUExtendLinkedHashMap<Integer, Object> lru = new LRUExtendLinkedHashMap<>(4);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        log.info(lru.toString());
        lru.put(2, 20);
        log.info(lru.toString());
        lru.get(1);
        log.info(lru.toString());
        lru.put(10, 10);
        log.info(lru.toString());
    }

}
