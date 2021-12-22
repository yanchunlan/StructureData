package com.example.ycl.structuredata.practice.calculate;

/**
 * author:  yanchunlan
 * date:  2021/12/06 16:18
 * desc: 合并n个有序链表
 */
public class Link1 {

    public static void main(String[] args) {
        Node[] nodes = new Node[3];

        // node0 0->1
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        node0.next = node1;
        nodes[0] = node0;

        // node1 4->5
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.next = node5;
        nodes[1] = node4;

        // node1 2->3
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.next = node3;
        nodes[2] = node2;

        Node node = mergeSortNode1(nodes);
//        Node node = mergeSortNode2(nodes);
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value).append("->");
            node = node.next;
        }
        System.out.println("node " + sb.toString());
    }

    // 1. 暴力法，直接排序
    private static Node mergeSortNode1(Node[] nodes) {
        if (nodes.length == 0) {
            return null;
        }

        Node result = null;
        for (int i = 0; i < nodes.length; i++) {
            result = mergeNode(result, nodes[i]);
        }
        return result;
    }

    // 2. 归并法
    private static Node mergeSortNode2(Node[] nodes) {
        if (nodes.length == 0) {
            return null;
        }

        Node result = mergeProcess(nodes, 0, nodes.length - 1);
        return result;
    }

    private static Node mergeProcess(Node[] nodes, int l1, int l2) {
        if (l1 == l2) {
            return nodes[l1];
        }
        int mid = l1 + (l2 - l1) / 2;
        Node n1 = mergeProcess(nodes, l1, mid);
        Node n2 = mergeProcess(nodes, mid + 1, l2);
        return mergeNode(n1, n2);
    }

    private static Node mergeNode(Node p1, Node p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        Node result = new Node(-1);
        Node pre = result;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        // 跳出循环，p1/p2有一个为null
        pre.next = p1 == null ? p2 : p1;
        return result.next;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
