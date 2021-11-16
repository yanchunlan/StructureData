package com.example.ycl.structuredata.structure_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import android.util.ArrayMap;
import android.util.SparseArray;
import androidx.collection.ArraySet;

import com.example.ycl.structuredata.structure_data.tree.BinaryTree;

/**
 * @Author: Ycl
 * @Date: 2018/7/11 22:05
 * @Desc: 数据结构的复习
 */
public class TestList {

    private static void arrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.get(2);
        list.remove(2);
        /*
            默认10
            add 扩容1.5倍，数组copy
            remove 移动位置的数组copy，并把最后一个数据置null
         */
    }

    private static void linkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1); // linkLast
        linkedList.push(2); // linkFirst
        ListIterator<Integer> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            Integer it = iterator.next();
            System.out.println("it "+it.intValue());
        }
        linkedList.removeLast(); // unlinkLast
         /*
            默认没有限制大小
            add 单项链表
            remove 返回当前对象，置空当前前后引用，置空前对象的next,全局参数last/first/size/modCount更新
         */
    }

    // ctrl+h  AS查看层级关系
    private static void vector_stack_queue() {
        Vector<Integer> vector = new Vector<>();
        vector.add(0);
        vector.add(1);
        vector.remove(1);
        /*
            默认10，扩容1.5倍，数组copy，移除也与ArrayList相同处理
            Vector与ArrayList类似，区别在于Vector每个方法添加了synchronized
         */

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.peek(); // 返回数据，容易返回异常
        stack.pop();  // 返回并删除数据，不返回异常
        /*
            Vector的子类，每个方法添加了synchronized
            默认是先进后出，后进先出，removeLast
         */

        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        queue.offer(0);
        queue.offer(1);
        queue.poll(); // 返回并删除数据
        /*
         * Queue<Integer> queue = new Queue<Integer>() {};
         * LinkedList
         * */
        // 作业： 中缀 -->> 后缀表达式
    }

    private static void hashMap() {
        // 推荐资料：https://www.zhihu.com/question/20733617
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        hashMap.put(1, 1);
        hashMap.get(1);
        hashMap.remove(1);

        /*
        数组+单向链表（>8，链表变红黑树）
        初始容量16，加载因子0.75 ,容量>加载因子*当前容量,对hash表rehash重建，容量*2
        put 先hashCode计算出key,如果key相同，分别: 1.比较equal，2.是否TreeNode，3.不是TreeNode则添加到8个则转换为红黑树
            resize 仅put方法前后及红黑树put，有调用resize，其余方法不调用

        hash
          原理：增加随机性，减少碰撞概率。
              int hash = h = key.hashCode()) ^ (h >>> 16)   【扰动函数，实验证明扰动函数可以减少碰撞】
              使用的key：(tab.length - 1) & hash    【取摸运算，hash太长，数组长度取模再余数】

              hashCode右移16位，正好是32b一半，与自己做异或，就混合了hash的高低位，高位保持住，低位随机
              tab.length - 1 的二进制...001111尾数为1，与

          冲突解决4种方式：
            1. 开放定址法
              线性（平方）探测再散列。线性发生冲突，使用某种探测技术往后找没有元素的（平方就是放在冲突+-1平方位置）
              优：更容易序列化。 缺：扩容成本高，额外计算，删除需要设置删除标记不方便
            2. 拉链法
               数组+链表。
               优：删除记录方便，可指针操作。 缺：记录随机分配内存中，跳转访问带来额外开销，指针记录不方便序列化
            3. 再hash
              再hash一次，2次hash结果不一样，就存储
            4. 建立公共溢出区
              hash表拆分基本表和溢出表，冲突的元素填入溢出表
         */
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(0, 0);
        linkedHashMap.remove(1);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        /*
            LinkedHashMap的父类是HashMap，唯一的区别是LinkedHashMap的value是双向链表，
         */

        Set<Integer> set = new ArraySet<>();
        set.add(0);

        /*
            value的hashCode与index的算法计算出来的参数作为key
         */

        SparseArray<Integer> sparseArray = new SparseArray<>(10);
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            ArrayMap<Integer,Integer> arrayMap = new ArrayMap<>(10);
        }
    }

    public static void main(String[] args) {
        // 集合
//        arrayList();
//        linkedList();
//        vector_stack_queue();
//        hashMap();

        // 二叉树
        BinaryTree.test();

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
//        new Josephus().test(); // 约瑟夫杀人法
//        BigCount  // 大数相乘

    }
}
