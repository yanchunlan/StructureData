package com.example.ycl.structuredata.structure_data.algo.sort1.search;

import com.example.ycl.structuredata.structure_data.algo.sort.BasicSort;
import com.example.ycl.structuredata.structure_data.algo.sort.Sort;

/**
 * author: ycl
 * date: 2018-07-25 0:40
 * desc: 二分法排序
 */
public class BinarySearch {

    /**
     * 递归的方式
     */
    public static int binarySearch(int elem, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (array[middle] == elem) {// 找到了
            System.out.println();
            System.out.println("找到对应元素值，下标为：" + middle);
            return elem;
        }
        if (array[middle] < elem) {// 找右边
            return binarySearch(elem, array, middle + 1, high);
        }
        if (array[middle] > elem) {// 找左边
            return binarySearch(elem, array, low, middle - 1);
        }
        return -1;
    }

    /**
     * 非递归
     */
    public static int directbinarysearch(int[] array, int elem) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (elem > array[middle]) {
                low = middle + 1;
            } else if (elem < array[middle]) {
                high = middle - 1;
            } else {
                System.out.println("找到相应元素，下标为：" + middle);
                return middle;
            }
        }
        return -1;
    }


    public static void test() {
        int[] array = {10, 23, 4, 3, 2, 5, 1, 2, 623, 92, 23, 23, 234, 2, 34, 234, 234, 2, 10};

        // 奇数排序
        Sort.printSort(array, "交换之前：");
        new BasicSort().basicSort(array);
        Sort.printSort(array, "交换后：");

        // 查找5的位置
//       int ret=
        binarySearch(5, array, 0, array.length - 1);
        directbinarysearch(array, 4);
//        System.out.println(""+ret);


    }
}
