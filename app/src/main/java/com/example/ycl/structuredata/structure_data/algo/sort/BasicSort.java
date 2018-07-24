package com.example.ycl.structuredata.structure_data.algo.sort;

import java.util.ArrayList;

/**
 * author: ycl
 * date: 2018-07-24 21:49
 * desc: 基数排序 (个位，十位，百位...一步一步的排序好久ok了)
 */
public class BasicSort {
    public void basicSort(int[] array) {
        int max = 0;//获取最大值
        for (int elem : array) {
            if (max < elem) {
                max = elem;
            }
        }
        int times = 0; // 获取最大值位数,就如=3，就是百位数
        while (max > 0) {
            max = max / 10;
            times++;
        }
        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> q = new ArrayList();
            queue.add(q);
        }

        for (int i = 0; i < times; i++) { // 一个位一个位的比较
            for (int j = 0; j < array.length; j++) {
                //获取对应的位的值（i为0是各位，1是10位，2是百位）
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> q = queue.get(x);
                q.add(array[j]);//把元素添加进对应下标数组
//                queue.set(x, q);//待定
            }
            int count = 0;// 收集
            for (int j = 0; j < 10; j++) {// 从10个数组中取出数据
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> q = queue.get(j);
                    array[count] = q.get(0);
                    q.remove(0);
                    count++;
                }
            }
        }
    }

    public void test() {
        int[] array2 = {136, 2, 6, 8, 9, 2, 8, 11, 23, 56, 34, 90, 89, 29, 145, 209, 320, 78, 3};
        Sort.printSort(array2, "交换之前：");
        basicSort(array2);
        Sort.printSort(array2, "交换后：");
    }
}
