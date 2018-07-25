package com.example.ycl.structuredata.structure_data.algo.recursion;

/**
 * @Author: Ycl
 * @Date: 2018/7/25 15:32
 * @Desc: 欧几里得-找到最大公约数
 */
public class Gcd {
    // (m>n)  m和n的最大公约数 = n 和m%n的最大公约数
    //  36 24  12 = 24  36%24=12       =  12 和 0

    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public void test() {
        System.out.println("gcd: " + gcd(36, 24));
        System.out.println("gcd: " + gcd(99, 55));
    }
}
