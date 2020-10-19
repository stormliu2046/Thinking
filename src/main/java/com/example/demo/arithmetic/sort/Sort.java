package com.example.demo.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @author robert
 */
@Slf4j
public class Sort {

    public static final Random RANDOM = new Random();

    /**
     * 冒泡排序
     */
    static class BubbleSort {
        public static void bubbleSort(int[] nums) {
            if (Objects.isNull(nums)) {
                return;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        public static void main(String[] args) {
            int[] nums = randomArrays();
            log.info(Arrays.toString(nums));
            bubbleSort(nums);
            log.info(Arrays.toString(nums));
            bubbleSort(new int[]{});
        }
    }

    /**
     * 选择排序
     */
    static class SelectionSort {
        public static void selectionSort(int[] nums) {
            if (Objects.isNull(nums)) {
                return;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        public static void main(String[] args) {
            int[] nums = randomArrays();
            log.info(Arrays.toString(nums));
            selectionSort(nums);
            log.info(Arrays.toString(nums));
        }
    }

    /**
     * 插入排序
     */
    static class InsertionSort{

        public void insertionSort(int[] nums) {
            for (int i = 1; i < nums.length; i ++) {
                int j = i;
                int temp = nums[i];
                while (j > 0 && nums[j-1] > temp) {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = temp;
            }
        }

        public static void main(String[] args) {
            Sort.InsertionSort insertionSort = new Sort.InsertionSort();
            int[] nums = randomArrays();
            log.info(Arrays.toString(nums));
            insertionSort.insertionSort(nums);
            log.info(Arrays.toString(nums));
        }

    }


    static class MergeSort {

    }

    public static int[] randomArrays() {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = RANDOM.nextInt(10);
        }
        return nums;
    }

}
