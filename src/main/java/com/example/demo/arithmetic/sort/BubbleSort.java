package com.example.demo.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 *
 * @author robert
 */
@Slf4j
public class BubbleSort {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        bubbleSort(createArray(10));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                //冒泡排序优化，如果没有发生元素交换，说明已经排好序了
                boolean flag = false;
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
                if (!flag) {
                    break;
                }
            }
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
