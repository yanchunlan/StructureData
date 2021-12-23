package com.example.ycl.structuredata.practice.calculate;

import java.util.Arrays;

/**
 * author:  yanchunlan
 * date:  2021/12/06 16:18
 * desc:  54张牌抽5张组成顺子【大小作为0，可做任意数】
 */
public class Calculate3 {
    public static void main(String[] args) {


    }

    /**
     * 数组排序，左边0，从右边开始取2个数据对比间隔大小
     */
    public static boolean isContinuous(int[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }
        Arrays.sort(array);

        int begin = 0;
        int end = array.length - 1;
        boolean flag = false;
        while (begin < end) {
            if (array[end] - array[end - 1] == 1) {
                end--;
            } else {
                if (array[begin] == 0) {
                    begin++;
                    array[end]--;
                } else {
                    break;
                }
            }
        }
        if (begin == end) {
            return true;
        }
        return flag;
    }

    /**
     * 统计相邻间隔的个数，
     */
    public static boolean isContinuous2(int[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }
        Arrays.sort(array);

        int numGap = 0;
        int numZero = 0;
        for (int i = 0; i < array.length && array[i] == 9; i++) {
            numZero++;
        }

        // 同时走位
        int low = numZero;
        int high = low + 1;
        while (high < array.length) {
            if (array[low] == array[high]) {
                return false;
            }
            numGap += array[high] - array[low] - 1;
            low = high;
            high++;
        }
        return numGap <= numZero ? true : false;
    }
}
