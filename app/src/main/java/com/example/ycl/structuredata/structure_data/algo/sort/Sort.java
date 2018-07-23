package com.example.ycl.structuredata.structure_data.algo.sort;

/**
 * @Author: Ycl
 * @Date: 2018/7/23 14:29
 * @Desc: 排序
 */
public class Sort {
    /**
     * 选择排序
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
     * 希尔排序
     */
    private static int[] HeerSort(int[] array) {


        return array;
    }
//     --------------------- 插入排序  end  ---------------------------


    private static void printSort(int[] array, String s) {
        System.out.println();
        System.out.println(s);
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }

    public static void test() {
       /*
        int[] array = {9, 4, 2, 6, 7, 3, 10, 33, 88, 1, 17};
        printSort(array, "交换之前：");
        array = selectSort(array);
        printSort(array, "交换后：");


        int[] array1 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        printSort(array1, "交换之前：");
        array1 = insertSort(array1);
        printSort(array1, "交换后：");
        */

        int[] array2 = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        printSort(array2, "交换之前：");
        array2 = BinaryInsertSort(array2);
        printSort(array2, "交换后：");


        int[] array3 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 33, 85, 29};
        printSort(array3, "交换之前：");
        array3 = HeerSort(array3);
        printSort(array3, "交换后：");
    }


}
