package com.example.ycl.structuredata.practice.calculate;

import java.util.Arrays;

/**
 * author:  yanchunlan
 * date:  2021/12/01 18:22
 * desc:  所有的奇数在数组前部并从低到高排序，所有的偶数在数组后部并从高到低排序
 */
public class Sort2 {

    public static void main(String[] args) {
        int[] array = {10, 9, 1, 8, 7, 6, 5, 4, 3, 2, 1};
        sort1(array);
        sort2(array);
        sort3(array);
        sort4(array);
        System.out.println(Arrays.toString(array));
    }

    // 双指针
    public static void sort4(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // 从2边往中间遍历
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // 找到前后2个奇偶数
            while (start < end && array[start] % 2 != 0) {
                start++;
            }
            while (start < end && array[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    // 辅助数组实现，偶数存储新数组，奇数存储原来数组位置
    private static void sort3(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] temp = new int[array.length];
        int tempIndex = 0;
        int index = 0;
        for (int item : array) {
            if (item % 2 == 0) {
                temp[tempIndex++] = item;
                continue;
            }
            array[index++] = item;
        }
        for (int i = index; i < array.length; i++) {
            array[index++] = temp[tempIndex--];
        }
    }

    // 冒泡法，奇偶交换
    private static void sort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        boolean flag = true;
        for (int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j <array.length - 1-i ; j++) {
                if (array[j] % 2 == 0 && array[j+1] % 2 != 0) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

    // 暴力法，偶数设置到最后
    private static void sort1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int j = i;
            if (array[i] % 2 == 0) {
                // 遇到偶数，设置到最后
                int temp = array[i];
                while (j < array.length - 1) {
                    array[j] = array[j + 1];
                    j++;
                }
                array[j] = temp;
            }
        }
    }
}
