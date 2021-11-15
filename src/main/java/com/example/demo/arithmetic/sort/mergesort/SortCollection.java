package com.example.demo.arithmetic.sort.mergesort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author robert
 * @Date 2021/2/23
 */
@Slf4j
public class SortCollection {
    public static final Random RANDOM = new Random();

    static class InsertSort {
        static void insertSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (arr[j] > temp) {
                        //复制
                        arr[j + 1] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + 1] = temp;
                log.info(i + "次排序：" + Arrays.toString(arr));
            }
        }
    }

    static class MergeSort {
        static void mergeSort(int[] arr, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
            log.info(Arrays.toString(arr));
        }

        static void merge(int[] arr, int left, int mid, int right) {
            int[] temp = new int[arr.length];
            int point1 = left;
            int point2 = mid + 1;
            int index = left;
            while (point1 <= mid && point2 <= right) {
                if (arr[point1] > arr[point2]) {
                    temp[index] = arr[point2];
                    point2++;
                } else {
                    temp[index] = arr[point1];
                    point1++;
                }
                index++;
            }
            while (point1 <= mid) {
                temp[index] = arr[point1];
                point1++;
                index++;
            }
            while (point2 <= right) {
                temp[index] = arr[point2];
                point2++;
                index++;
            }
            System.arraycopy(temp, left, arr, left, right - left + 1);
        }
    }

    static class BubbleSort {
        static void bubbleSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                        flag = false;
                    }
                }
                if (flag) {
                    return;
                }
                log.info(i + "次排序：" + Arrays.toString(arr));
            }
        }
    }

    class QuickSort {
        public void quickSort(int[] arr, int left, int right) {
            int ll = left;
            int rr = right;
            int base = arr[left];
            while (ll < rr) {
                while (ll < rr && arr[rr] >= base) {
                    rr--;
                }
                if (ll < rr) {
                    int temp = arr[rr];
                    arr[rr] = arr[ll];
                    arr[ll] = temp;
                    ll++;
                }
                while (ll < rr && arr[ll] <= base) {
                    ll++;
                }
                if (ll < rr) {
                    int temp = arr[ll];
                    arr[ll] = arr[rr];
                    arr[rr] = temp;
                    rr--;
                }
            }
            if (left < ll) {
                quickSort(arr, left, ll - 1);
            }
            if (ll < right) {
                quickSort(arr, ll + 1, right);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    class SelectionSort {
        public void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                log.info(i + "次排序：" + Arrays.toString(arr));
            }
        }
    }

    public static int[] createArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(100);
        }
        log.info(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = createArray(10);
//        InsertSort.insertSort(arr);
//        MergeSort.mergeSort(arr, 0, arr.length - 1);
//        BubbleSort.bubbleSort(arr);
//        new SortCollection().new SelectionSort().selectionSort(arr);
        new SortCollection().new QuickSort().quickSort(arr, 0, arr.length - 1);
    }
}

