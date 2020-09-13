package com.example.demo.arithmetic.sort;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @author robert
 */
public class Sort {

    public Sort(){}

    /**
     * 冒泡排序
     */
    static class BubbleSort {
        public static void bubbleSort(int[] nums) {
            if (Objects.isNull(nums)) {
                return;
            }
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i + 1; j < nums.length; j ++) {
                    if (nums[i] > nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        public static void main(String[] args) {
            int[] nums = randomArrays();
            System.out.println(Arrays.toString(nums));
            bubbleSort(nums);
            System.out.println(Arrays.toString(nums));
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
            System.out.println(Arrays.toString(nums));
            selectionSort(nums);
            System.out.println(Arrays.toString(nums));
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
            System.out.println(Arrays.toString(nums));
            insertionSort.insertionSort(nums);
            System.out.println(Arrays.toString(nums));
        }

    }

    public static int[] randomArrays() {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10);
        }
        return nums;
    }

}
