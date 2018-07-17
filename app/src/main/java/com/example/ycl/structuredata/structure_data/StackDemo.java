package com.example.ycl.structuredata.structure_data;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Ycl
 * @Date: 2018/7/14 14:49
 * @Desc:
 *
 * 题目：

问题描述
　　输入一个只包含加减乖除和括号的合法表达式，求表达式的值。其中除表示整除。
输入格式
　　输入一行，包含一个表达式。
输出格式
　　输出这个表达式的值。
样例输入
1-2+3*(4-5)
样例输出
-4
数据规模和约定
　　表达式长度不超过100，表达式运算合法且运算过程都在int内进行。


初看此题，从人的直观角度来说很简单，先遍历括号内的运算完再重新遍历，但是很麻烦。

回忆起了后缀表达式的知识

中缀表达式转后缀表达式的方法：
1.遇到操作数：直接输出（添加到后缀表达式中）
2.栈为空时，遇到运算符，直接入栈
3.遇到左括号：将其入栈
4.遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
5.遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
6.最终将栈中的元素依次出栈，输出。

后缀表达式的计算机求值：
与前缀表达式类似，只是顺序是从左至右：
从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 op 栈顶元素），并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果。
例如后缀表达式“3 4 + 5 × 6 -”：
(1) 从左至右扫描，将3和4压入堆栈；
(2) 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素，注意与前缀表达式做比较），计算出3+4的值，得7，再将7入栈；
(3) 将5入栈；
(4) 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
(5) 将6入栈；
(6) 最后是-运算符，计算出35-6的值，即29，由此得出最终结果。



一开始，我先把中缀表达式转换为后缀表达式，再对后缀表达式求值。

有一个很大的问题，数字的保存，转化为后缀表达式时保存为char字符，对于大于9的数字保存很麻烦。

后来想了想，可以直接借用后缀表达式的计算方法。
 *
 *
 *
 */
public class StackDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> nums = new Stack<>(); // 保存数字
        Stack<Character> opes = new Stack<Character>(); // 保存操作符
        String string = scanner.nextLine();  // “3 4 + 5 × 6 -”

        int n = 0;// 保存每一个数字
        char[] cs = string.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char temp = cs[i];
            if (Character.isDigit(cs[i])) {
                n = 10 * n + Integer.parseInt(String.valueOf(cs[i])); // 大于10的数字保存
            } else {
                if (n != 0) {
                    nums.push(n);
                    n = 0;
                }
                if (temp == '(') {
                    opes.push(temp);
                } else if (temp == ')') {
                    while (opes.peek() != '(') { // 括号里面运算完
                        int t = cal(nums.pop(), nums.pop(), opes.pop());
                        nums.push(t);
                    }
                    opes.pop();
                } else if (isType(temp) > 0) {
                    if (opes.isEmpty()) { // 栈为空直接入栈
                        opes.push(temp);
                    } else {
                        // 若栈顶元素优先级大于或等于要入栈的元素,将栈顶元素弹出并计算,然后入栈
                        if (isType(opes.peek()) >= isType(temp)) {
                            int t = cal(nums.pop(), nums.pop(), opes.pop());
                            nums.push(t);
                        }
                        opes.push(temp);
                    }
                }
            }
        }

        // 最后一个字符若是数字,未入栈
        if (n != 0) {
            nums.push(n);
        }
        while (!opes.isEmpty()) {
            int t = cal(nums.pop(), nums.pop(), opes.pop());
            nums.push(t);
        }
        System.out.println(nums.pop());

    }
    // 返回的是运算符的优先级,数字和()不需要考虑
    public static int isType(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    // 运算次序是反的,跟入栈出栈次序有关
    public static int cal(int m, int n, char c) {
        int sum = -987654321;
        if (c == '+') {
            sum = n + m;
        } else if (c == '-') {
            sum = n - m;
        } else if (c == '*') {
            sum = n * m;
        } else if (c == '/') {
            sum = n / m;
        }
        return sum;
    }
}
