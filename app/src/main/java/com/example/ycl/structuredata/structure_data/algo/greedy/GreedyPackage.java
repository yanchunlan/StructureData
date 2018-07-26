package com.example.ycl.structuredata.structure_data.algo.greedy;

import java.util.Arrays;

/**
 * @Author: Ycl
 * @Date: 2018/7/26 10:34
 * @Desc: 贪心算法（背包装满问题）
 */
public class GreedyPackage {
    private int MAX_WEIGHT = 90;
    private int[] weights = {35, 30, 60, 50, 40, 10, 25};
    private int[] values = {10, 40, 30, 50, 35, 40, 30};

    private void packageGreedy(int capacity,// 剩下的容量
                               int weights[], //体重
                               int[] values) { // 价值
        int n = weights.length;
        double[] r = new double[n]; // 性价比数组
        int[] index = new int[n]; // 按性价比排序物品的下标
        for (int i = 0; i < n; i++) {
            r[i] = values[i] / (double) weights[i];
            index[i] = i;
        }

        // 降序排序 物品和下标
        double temp;
        int in;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    in = index[i];
                    index[i] = index[j];
                    index[j] = in;
                }
            }
        }

        // 排序好的重量和价值分别存到数组中
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = weights[index[i]];
            v1[i] = values[index[i]];
        }
        // 上面完成了性价比从大到小的排序，下面装包
        int[] x = new int[n];
        int maxValue = 0; // 总价值
        for (int i = 0; i < n; i++) {
            if (w1[i] < capacity) { // 小于包容量，就代表还能被装下
                x[i] = 1;// 表示该物品被装了
                maxValue += v1[i];
                System.out.println("物品 "+w1[i]+" 被放进包包");
                capacity = capacity - w1[i];
            }
        }
        System.out.println("总共放下的物品数量："+ Arrays.toString(x));
        System.out.println("最大价值："+maxValue);
    }

    public void test() {
        packageGreedy(MAX_WEIGHT, weights, values);
    }

}
