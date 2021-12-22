package com.example.ycl.structuredata.practice;

import com.example.ycl.structuredata.practice.calculate.Calculate1;
import com.example.ycl.structuredata.practice.calculate.Calculate2;
import com.example.ycl.structuredata.practice.calculate.Link1;
import com.example.ycl.structuredata.practice.calculate.Sort1;
import com.example.ycl.structuredata.practice.calculate.Sort2;

/**
 * author:  yanchunlan
 * date:  2021/12/01 18:22
 * desc:
 */
public class _05_Calculate {

    public static void main(String[] args) {
        calculate(args);
        link(args);
        sort(args);
    }

    private static void sort(String[] args) {
        // 给定一个数组，其值先递增后递减，找出不重复的值
        Sort1.main(args);
        // 所有的奇数在数组前部并从低到高排序，所有的偶数在数组后部并从高到低排序
        Sort2.main(args);
        // 大文件数据排序
    }

    private static void link(String[] args) {
        // 合并n个有序链表
        Link1.main(args);
    }

    private static void calculate(String[] args) {
        // 计算：1+2*3/4
        Calculate1.main(args);
        // 10个糖分给3个人
        Calculate2.main(args);
        // 54张牌抽5张组成顺子
    }
}
