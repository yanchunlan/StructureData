package com.example.ycl.structuredata.structure_data.algo.sort;

import java.util.Arrays;

/**
 * @Author: Ycl
 * @Date: 2018/7/23 14:29
 * @Desc: 排序
 */
public class Sort {

    /**
     * 冒泡排序
     * 时间复杂度 n2,空间复杂度n,稳定
     */
    private static int[] bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }
        // 每次排序把最大值排序到最后
        int temp, length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    /**
     * 选择排序
     * 时间复杂度 n2,空间复杂度n,不稳定
     */
    private static int[] selectSort(int[] array) {
        // 选择排序的优化 ，以前是直接在for里面直接替换值，现在是for里面找到最小值的下标，再替换
        int min, temp, length = array.length;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }


    //     --------------------- 插入排序  start  ---------------------------

    /**
     * 直接插入排序
     */
    private static int[] insertSort(int[] array) {
        int temp, j, length = array.length;
        for (int i = 1; i < length; i++) {
            //待插入元素
            temp = array[i];
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // j 为保存break之前的j的值
            array[j + 1] = temp;
        }
        return array;
    }

    /**
     * 二分插入排序
     */
    private static int[] BinaryInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            //确定要插入的位置
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < array[mid]) {
                    //如果值比中间值小，让right左移到中间下标-1
                    right = mid - 1;
                } else {
                    //如果值比中间值大,让left右移到中间下标+1
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            if (left != i) {
                array[left] = temp;
            }
        }
        return array;
    }


    /**
     * 希尔排序 : 增量排序
     * 不稳定 ； 颗粒越小，越接近冒泡排序，
     * 比其他插入法更加有优越性
     */
    private static int[] HillSort(int[] array) {
        int length = array.length;
        int d = length / 2;
        int temp;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < length; j += d) {
                    if (array[j] > array[j + d]) {
                        temp = array[j];
                        array[j] = array[j + d];
                        array[j + d] = temp;
                    }
                }
            }
            if (d == 1) {
                break;
            }
            d--;
        }

        return array;
    }
    //     --------------------- 插入排序  end  ---------------------------


    //     --------------------- 堆排序  start  ---------------------------
    private static int[] heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        //建立最大堆
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            //最大的在0位置，那么开始沉降，这样每交换一次最大的值就丢到最后了
            exchangeElements(array, 0, i);
            //继续获取0位置最大值
            maxHeap(array, i, 0);
        }
        return array;
    }

    // 只需要遍历一半就可以得到值了
    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int half = (array.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        // 找到最大值，并返回最大值的下标
        if (left < length && array[left] > array[i]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (i != largest) {// 根节点不是最大值，那么其孩子就有一个是最大值，就需要交换
            exchangeElements(array, i, largest);
            maxHeap(array, length, largest);// 需要再对其最大值进行再次根节点遍历
        }
    }

    /**
     * 在数组a里面进行2个下标元素交换
     */
    private static void exchangeElements(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
    //     --------------------- 堆排序  end  ---------------------------


    public static void printSort(int[] array, String s) {
        System.out.println();
        System.out.println(s);
        for (int arr : array) {
            System.out.print(arr + " ");
        }
//        System.out.print(Arrays.toString(array) + " ");
    }

    public static void test() {
        int[] array = {9, 4, 2, 6, 7, 3, 10, 33, 88, 1, 17};
        printSort(array, "交换之前：");
        array = selectSort(array);
        printSort(array, "交换后：");


        int[] array1 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        printSort(array1, "交换之前：");
        array1 = insertSort(array1);
        printSort(array1, "交换后：");


        int[] array2 = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        printSort(array2, "交换之前：");
        array2 = BinaryInsertSort(array2);
        printSort(array2, "交换后：");


        int[] array3 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 33, 85, 29};
        printSort(array3, "交换之前：");
        array3 = HillSort(array3);
        printSort(array3, "交换后：");

        int[] array4 = {19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7};
        printSort(array4, "交换之前：");
        array4 = heapSort(array4); // 因为数组都是引用类型，所以放入进去之后修改，再取也是有效的
        printSort(array4, "交换后：");
    }
}
