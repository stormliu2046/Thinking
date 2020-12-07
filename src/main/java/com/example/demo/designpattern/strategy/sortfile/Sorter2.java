package com.example.demo.designpattern.strategy.sortfile;

import com.example.demo.designpattern.strategy.sortfile.impl.ConcurrentExternalSort;
import com.example.demo.designpattern.strategy.sortfile.impl.ExternalSort;
import com.example.demo.designpattern.strategy.sortfile.impl.MapReduceSort;
import com.example.demo.designpattern.strategy.sortfile.impl.QuickSort;

import java.io.File;

/**
 * @author robert
 */
public class Sorter2 {

    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg;
        if (fileSize < 6 * GB) {
            sortAlg = new QuickSort();
        } else if (fileSize < 10 * GB) {
            sortAlg = new ExternalSort();
        } else if (fileSize < 100 * GB) {
            sortAlg = new ConcurrentExternalSort();
        } else {
            sortAlg = new MapReduceSort();
        }
        sortAlg.sort(filePath);
    }
}
