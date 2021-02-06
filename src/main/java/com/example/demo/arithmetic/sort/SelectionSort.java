package com.example.demo.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 *
 * @author robert
 */
@Slf4j
public class SelectionSort {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        selectionSort(createArray(10));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;

            log.info("第" + i + "次排序：" + Arrays.toString(array));
        }
    }

    public static int[] createArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(100);
        }
        log.info("createArray:" + Arrays.toString(array));
        return array;
    }
}
