package com.example.demo.arithmetic.sort;

import com.example.demo.arithmetic.sort.mergesort.InsertSort;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author robert
 */
@Slf4j
public class QuickSort {

    public static void main(String[] args) {
        quickSort(InsertSort.createArray(10), 0, 9);
    }

    public static void quickSort(int[] array, int left, int right) {
        int ll = left;
        int rr = right;
        int baseValue = array[left];
        while (ll < rr) {
            while (ll < rr && array[rr] >= baseValue) {
                rr--;
            }
            if (ll < rr) {
                int temp = array[rr];
                array[rr] = array[ll];
                array[ll] = temp;
                ll++;
            }
            while (ll < rr && array[ll] <= baseValue) {
                ll++;
            }
            if (ll < rr) {
                int temp = array[rr];
                array[rr] = array[ll];
                array[ll] = temp;
                rr--;
            }
        }
        if (left < ll) {
            quickSort(array, left, ll - 1);
        }
        if (ll < right) {
            quickSort(array, ll + 1, right);
        }
        log.info(Arrays.toString(array));
    }
}
