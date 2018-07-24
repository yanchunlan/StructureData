package com.example.ycl.structuredata.structure_data.algo.sort;

/**
 * @Author: Ycl
 * @Date: 2018/7/24 15:59
 * @Desc: 快速排序
 */
public class QuickSort {
    public void quick(int[] array) {
        if (array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    // 快速排序
    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    // 获取中间下标
    private int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;//插入到排序后正确的位置
        return low;
    }

    public void test() {
        int[] array2 = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        Sort.printSort(array2, "交换之前：");
        quick(array2);
        Sort.printSort(array2, "交换后：");
    }

}
