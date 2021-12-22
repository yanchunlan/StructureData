package com.example.ycl.structuredata.practice.calculate;

import java.util.LinkedList;

/**
 * author:  yanchunlan
 * date:  2021/12/01 18:22
 * desc:  给定一个数组，其值先递增后递减，找出不重复的值
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 3, 4, 9, 10, 9, 5, 4, 3, 2, 2, 2};
//        int result = sort1(array);
        int result = sort2(array);
        System.out.println("result: " + result);
    }

    // 双指针，前后2个数据分别比较，再比较前后数据与+1的数据
    /*public static int sort1(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        int left = 0;
        int right = input.length - 1;
        int result = 0;
        LinkedList linkedList = new LinkedList();
        while (left <= right) {
            if (input[left] < input[right] && input[left] < input[left + 1]) {
                linkedList.addFirst(input[left]);
                left++;
                result++;
            } else if (input[left] < input[right] && input[left] == input[left + 1]) {
                left++;
            } else if (input[left] > input[right] && input[right] < input[right - 1]) {
                linkedList.addLast(input[right]);
                right--;
                result++;
            } else if (input[left] > input[right] && input[right] == input[right - 1]) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println("result " + linkedList.toString());
        return result;
    }*/

    // 双指针，前后2个数据分别比较，再比较前后数据与+1的数据
    public static int sort2(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        int left = 0;
        int right = input.length - 1;
        int result = 0;
        LinkedList linkedList = new LinkedList();

        int temp;
        if (input[left] < input[right]) {
            temp = input[left];
        } else {
            temp = input[right];
        }
        while (left <= right) {
            if (input[left] <= input[right]) {
                if (input[left] != temp) {
                    temp = input[left];
                    linkedList.addFirst(input[left]);
                    result++;
                }
                left++;
            } else {
                if (input[right] != temp) {
                    temp = input[right];
                    linkedList.addLast(input[right]);
                    result++;
                }
                right--;
            }
        }

        System.out.println("result " + linkedList.toString());
        return result;
    }
}
