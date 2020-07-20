package com.example.ycl.structuredata.practice;


import androidx.collection.LruCache;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * author:  ycl
 * date:  2020/07/20 10:28
 * desc:    如何实现LRU算法
 *          https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/LRU%E7%AE%97%E6%B3%95.md
 */
class _01_Lrucache {

    public static void main(String[] args) {

        LruCache<Integer, Integer> cache = new LruCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println("size toString " + cache.toString());
        cache.put(4, 5);
        System.out.println("size toString " + cache.toString());
        cache.remove(3);
        System.out.println("size toString " + cache.toString());
        cache.put(1, 2);
        System.out.println("size toString " + cache.toString());
        System.out.println("size " + cache.size());

        // ----------------------------------------
        Lrucache lrucache = new Lrucache(3);
        lrucache.put(1, 1);
        lrucache.put(2, 2);
        lrucache.put(3, 3);
        System.out.println("2 size toString " + lrucache.toString());
        lrucache.put(4, 5);
        System.out.println("2 size toString " + lrucache.toString());
        lrucache.put(1, 2);
        System.out.println("2 size toString " + lrucache.toString());
    }


    /**
     * 源码主要采用的是 linkedHashMap , 可以看做是是hashMap与linkedList的结合
     * 如下仿写
     */
    static class Lrucache {

        HashMap<Integer, Node> map; // 为了查找Node是O(1),快速查找数据
        int capacity;
        DoubleList cache; // 为什么需要这样的集合类管理，是因为有优先级顺序，需要一个双向链表来解决这个问题，所以暑假需要最终缓存在双向链表中

        public Lrucache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int value = map.get(key).value;
            put(key, value);
            return value;
        }

        // 放入数据 先内再外，即先缓存再map
        public void put(int key, int val) {
            if (!map.containsKey(key)) { // 直接插入新
                if (capacity == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                Node node = new Node(key, val);
                cache.addFirst(node);
                map.put(key, node);
            } else {// 删除旧，插入新
                Node last = map.get(key);
                cache.remove(last);
                map.remove(last.key);

                Node node = new Node(key, val);
                cache.addFirst(node);
                map.put(key, node);
            }
        }

        @Override
        public String toString() {
            return "Lrucache{" +
                    "map=" + map +
                    ", \ncapacity=" + capacity +
                    ", \ncache=" + cache +
                    '}';
        }
    }


    // 优先级顺序的缓存Node的集合,双链表
    @Deprecated
    static class DoubleList {

        LinkedList<Node> list = new LinkedList<>();// LinkedList 实际上是不准确的，应该是制作一个双链表的结构，充分使用Node的prev, next

        public void addFirst(Node x) {
            list.addFirst(x);
        }

        public void remove(Node x) {
            list.remove(x);
        }

        public Node removeLast() {
            return list.removeLast();
        }

        public int size() {
            return list.size();
        }
    }


    static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

