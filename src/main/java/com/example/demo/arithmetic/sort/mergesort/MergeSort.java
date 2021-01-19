package com.example.demo.arithmetic.sort.mergesort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author robert
 */
@Slf4j
public class MergeSort {

    public static void main(String[] args) {
        int[] array = InsertSort.createArray(10);
        mergeSort(array, 0, array.length - 1);
        log.info(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tempArray = new int[array.length];
        int point1 = left;
        //注意point是从mid+1开始的
        int point2 = mid + 1;
        int index = left;
        while (point1 <= mid && point2 <= right) {
            if (array[point1] > array[point2]) {
                //原数组赋值给临时数组
                tempArray[index] = array[point2];
                index++;
                point2++;
            } else {
                tempArray[index] = array[point1];
                index++;
                point1++;
            }
        }
        while (point1 <= mid) {
            tempArray[index] = array[point1];
            index++;
            point1++;
        }
        while (point2 <= right) {
            tempArray[index] = array[point2];
            index++;
            point2++;
        }
        System.arraycopy(tempArray, left, array, left, right - left + 1);
    }

}
