package com.example.ycl.structuredata.structure_data.algo.recursion;

/**
 * @Author: Ycl
 * @Date: 2018/7/25 16:10
 * @Desc: 求阶乘 n! (递归的思想)
 */
public class CalNFact {
    public long f(long n) {
        if (n == 1) {
            return n;
        } else {
            return n * f(n - 1);
        }
    }

    public void test() {
        System.out.println("5! : " + f(20));
    }
}
