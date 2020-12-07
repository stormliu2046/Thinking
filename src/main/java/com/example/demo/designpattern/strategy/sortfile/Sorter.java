package com.example.demo.designpattern.strategy.sortfile;

import java.io.File;

/**
 * @author robert
 */
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize < 6 * GB) {
            quickSort(filePath);
        } else if (fileSize < 10 * GB) {
            externalSort(filePath);
        } else if (fileSize < 100 * GB) {
            concurrentExternalSort(filePath);
        } else {
            mapreduceSort(filePath);
        }
    }

    private void quickSort(String filePath) {
        // 快递排序
    }

    private void externalSort(String filePath) {
        // 外部排序
    }

    private void concurrentExternalSort(String filePath) {
        //多线程外部排序
    }

    private void mapreduceSort(String filePath) {
        // 利用MapReduce多机排序
    }
}
