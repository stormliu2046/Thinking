package com.example.demo.designpattern.strategy.sortfile;

import com.example.demo.designpattern.strategy.sortfile.impl.ConcurrentExternalSort;
import com.example.demo.designpattern.strategy.sortfile.impl.ExternalSort;
import com.example.demo.designpattern.strategy.sortfile.impl.MapReduceSort;
import com.example.demo.designpattern.strategy.sortfile.impl.QuickSort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert
 */
public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("tyoe should not be empty.");
        }
        return algs.get(type);
    }
}
