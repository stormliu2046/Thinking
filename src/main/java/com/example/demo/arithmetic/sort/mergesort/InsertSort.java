package com.example.demo.arithmetic.sort.mergesort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 *
 * @author robert
 */
@Slf4j
public class InsertSort {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        insertSort(createArray(10));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
            log.info("第" + i + "次排序：" + Arrays.toString(array));
        }
    }

    public static int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(100);
        }
        log.info("生成的数组：" + Arrays.toString(array));
        return array;
    }

}
