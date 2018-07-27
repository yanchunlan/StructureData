package com.example.ycl.structuredata.structure_data.algo.sort3.josephus;

/**
 * @Author: Ycl
 * @Date: 2018/7/27 17:00
 * @Desc: 约瑟夫杀人法
 */
public class Josephus {
    public static int N = 20;
    public static int M = 5;// 数到M就杀一个人


    class Node {
        int val; // 下标
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void killNode() {
        // 完成头尾相接的链表
        Node header = new Node(1);
        Node x = header;
        for (int i = 2; i <=N; i++) {
            x = (x.next = new Node(i));
        }
        x.next = header;

        while (x != x.next) {
            for (int i = 1; i < M; i++) {
                x = x.next; // 断掉第5个
            }
            // 此时是第4个，断掉5，则4的下一个就是6
            System.out.println(x.next.val + "被干掉 ");
            x.next = x.next.next;
        }
        System.out.println("最后这个幸运儿是："+x.val);
    }


    public void test() {
        killNode();
    }
}
