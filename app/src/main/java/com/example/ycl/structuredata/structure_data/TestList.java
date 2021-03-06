package com.example.ycl.structuredata.structure_data;

import com.example.ycl.structuredata.structure_data.algo.sort3.josephus.Josephus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @Author: Ycl
 * @Date: 2018/7/11 22:05
 * @Desc: 数据结构的复习
 */
public class TestList {

    private void arrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
//        val link :LinkedList<Int> = arrayListOf()
    }

    private void linkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListIterator<Integer> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            Integer it = iterator.next();

        }
    }

    private void vector_Queue() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.remove(1);

        /*
         * Queue<Integer> queue = new Queue<Integer>() {};
         * LinkedList
         * */
        // 作业： 中缀 -->> 后缀表达式
    }

    private void hashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    }


    public static void main(String[] args) {
        // 二叉树
//        BinaryTree.test();

        // 图
//        Graph.test();
//        GraphKruskal.test();
//        DnJavaDijstra.test();
//        DnGraphTopologic.test();

        // 排序
//        Sort.test();
//        new QuickSort().test();
//        new MergeSort().test();
//        new BasicSor().test();
//        BinarySearch.test();

        // 递归: 自己调用自己 ； 迭代：调用别人
//        new HanNoTa().test(); // 汉诺塔
//        new Gcd().test(); // 欧几里得
//        new CalNFact().test(); // 阶乘

        // 穷举：泊松分酒
//        new ShareWine().test(); // 阶乘

        // 贪心算法
//        new GreedyPackage().test(); // 背包装满问题

        // 分治算法
//        new SportsSchedule().test(); // 球队比赛安排问题
//        new ChessBoardProblem().test(); //棋盘覆盖

        // 动态规划-回溯算法
//        new LCS().test(); // 寻找相识字符
//        new Queen().test(); // 棋盘行列不能相同，斜对角也不能相同
        new Josephus().test(); // 约瑟夫杀人法
//        BigCount  // 大数相乘

    }
}
