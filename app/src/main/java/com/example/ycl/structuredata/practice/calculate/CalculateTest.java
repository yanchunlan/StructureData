package com.example.ycl.structuredata.practice.calculate;

import java.util.LinkedList;
import java.util.Stack;

/**
 * author:  yanchunlan
 * date:  2021/12/06 16:18
 * desc:
 */
public class CalculateTest {

  // 计算：1+2*3/4
  public static double calculate_01(String str) {

    char[] array = str.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < array.length; i++) {
      char item = array[i];
      if (item == '+' || item == '*' || item == '/') {
        stack.push(item);
      } else {
        char result;
        if (stack.size() > 0 && stack.peek() == '*') {
          stack.pop();
          result = (char) (((stack.pop() - '0') * (item - '0')) + '0');
        } else if (stack.size() > 0 && stack.peek() == '/') {
          stack.pop();
          result = (char) (((stack.pop() - '0') / (item - '0')) + '0');
        } else {
          result = item;
        }
        if (i == array.length - 1) {
          if (stack.peek() == '+') {
            stack.pop();
            result = (char) (((stack.pop() - '0') + (result - '0')) + '0');
          }
        }
        stack.push(result);
      }
    }
    return (stack.pop() - '0');
  }

  // 给定一个数组，其值先递增后递减，找出不重复的值
  public static int calculate_02(int[] input) {
    if (input.length == 0) {
      return 0;
    }

    /*
   分析：i/i+1数据比较，i/last比较，last/last-1比较，总结需要3个地方比较，
   递增位置有前后2处，所以可能前面递增，后面递减,所以应该是定义2指针去解决此问题
    */

    int left = 0;
    int right = input.length - 1;

    int result = 0;
    LinkedList linkedList = new LinkedList();

//    while (left <= right) {
//      if (input[left] < input[right] && input[left] < input[left + 1]) {
//        linkedList.addFirst(input[left]);
//        left++;
//        result++;
//      } else if (input[left] < input[right] && input[left] == input[left + 1]) {
//        left++;
//      } else if (input[left] > input[right] && input[right] < input[right - 1]) {
//        linkedList.addLast(input[right]);
//        right--;
//        result++;
//      } else if (input[left] > input[right] && input[right] == input[right - 1]) {
//        right--;
//      } else {
//        left++;
//      }
//    }
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

  public static void mergeSortNode() {
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

    Node node = mergeSortNode(nodes);
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.value).append("->");
      node = node.next;
    }
    System.out.println("node "+sb.toString());
  }

  private static Node mergeSortNode(Node[] nodes) {
    if (nodes.length == 0) {
      return null;
    }

    // 1. 暴力法，直接排序
    Node result = null;
//    for (int i = 0; i < nodes.length; i++) {
//      result=mergeNode(result, nodes[i]);
//    }
    // 2. 归并法
    result = mergeProcess(nodes, 0, nodes.length-1);
    return result;
  }

  private static Node mergeProcess(Node[] nodes, int l1, int l2) {
    if (l1 == l2) {
      return nodes[l1];
    }
    int mid = l1 + (l2 - l1) / 2;
    Node n1 = mergeProcess(nodes, l1, mid);
    Node n2 = mergeProcess(nodes, mid+1, l2);
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
    Node pre=result;
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

  static class Node{
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
