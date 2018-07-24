package com.example.ycl.structuredata.structure_data.algo.sort;

/**
 * @Author: Ycl
 * @Date: 2018/7/24 16:28
 * @Desc: 归并排序（稳定排序，取中间节点，分开分开分开）
 */
public class MergeSort {
    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right); // 合并
        }
    }

    private void merge(int[] a, int left, int mid, int right) {
        int[] temArray = new int[a.length];// 局部变量用完会回收，不会造成多少的内存消耗
        int third = left;

        int rightStart = mid + 1;
        int tmp = left;

        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while (left <= mid && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                temArray[third++] = a[left++];
            } else {
                temArray[third++] = a[rightStart++];
            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while (left <= mid) {
            temArray[third++] = a[left++];
        }
        //如果右边还有数据
        while (rightStart <= right) {
            temArray[third++] = a[rightStart++];
        }
        //再把值付还给原数组
        while (tmp <= right) {
            a[tmp] = temArray[tmp++];
        }
    }

    public void test() {
        int[] a = {90, 3, 2, 67, 44, -9, 87, 65, 11, 9, 2, 8};
        Sort.printSort(a, "交换之前：");
        mergeSort(a, 0, a.length - 1);
        Sort.printSort(a, "交换后：");
    }
}
