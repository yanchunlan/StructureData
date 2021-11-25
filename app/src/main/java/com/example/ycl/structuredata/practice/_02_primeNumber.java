package com.example.ycl.structuredata.practice;

import java.util.Arrays;

/**
 * author:  ycl
 * date:  2020/07/20 11:07
 * desc:    如何高效寻找素数
 * 只能被 1 和它本身整除，那么这个数就是素数
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/%E6%89%93%E5%8D%B0%E7%B4%A0%E6%95%B0.md
 */
class _02_primeNumber {
    public static void main(String[] args) {
        countPrimes(5);
    }

    // [2,n) 内的素数
    static int countPrimes(int n) {
        // 缓存策略，额外空间，针对结果缓存
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);


        /*
         *  严格意义上来说是分别遍历 [2,n)
         *  但是一个数字是素数了，它的倍数2倍，或者自己倍就不是素数，所以内循环只需要 j= i*i即可
         *  外部循环，一般只需要对数字遍历一半即可，因为后半部分实际上是前半部分的倒置
         */
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) { // 后面同样的位置，存在逻辑差不多的，直接被false了就不再需要处理了
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }


        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }

}
