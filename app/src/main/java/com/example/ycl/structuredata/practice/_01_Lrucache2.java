package com.example.ycl.structuredata.practice;


import java.util.HashMap;
import java.util.LinkedList;

import androidx.collection.LruCache;

/**
 * author:  ycl
 * date:  2020/07/20 10:28
 * desc:    如何实现LRU算法
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF
 * %95%E7%B3%BB%E5%88%97/LRU%E7%AE%97%E6%B3%95.md
 */
class _01_Lrucache2 {

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
          Node first = cache.removeFirst();
          map.remove(first.key);
        }
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
      } else {// 删除旧，插入新
        Node last = map.get(key);
        cache.remove(last);
        map.remove(last.key);

        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
      }
    }

    @Override
    public String toString() {
      return "Lrucache{" +
          ", \ncapacity=" + capacity +
          ", \ncache=" + cache +
          '}';
    }
  }

  static class DoubleList {
    Node head, tail; // 虚拟头尾，不算做数据
    int size;

    public DoubleList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      size = 0;
    }

    public void addLast(Node node) {
      node.prev = tail.prev;
      node.next = tail;
      tail.prev.next = node;
      tail.prev = node;
      size++;
    }

    public void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
    }

    public Node removeFirst() {
      if (head.next == tail) {
        return null;
      }
      Node first = head.next;
      remove(first);
      return first;
    }

    public int size() {
      return size;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node x = head.next;
      while (x.next != null) {
        sb.append(x.key).append(":").append(x.value).append(";");
        x = x.next;
      }
      return "DoubleList{" +
          "cache=" + sb.toString()+
          ", size=" + size +
          '}';
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

