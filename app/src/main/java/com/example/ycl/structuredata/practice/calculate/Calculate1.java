package com.example.ycl.structuredata.practice.calculate;

import java.util.Stack;

/**
 * author:  yanchunlan
 * date:  2021/12/06 16:18
 * desc: 计算：1+2*3/4
 */
public class Calculate1 {
    public static void main(String[] args) {
        String str = "1+2*3/4";
        double result = calculate(str);
        System.out.println("result: " + result);
    }

    public static double calculate(String str) {
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
}
