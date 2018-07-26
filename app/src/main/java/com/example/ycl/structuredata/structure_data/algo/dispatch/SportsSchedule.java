package com.example.ycl.structuredata.structure_data.algo.dispatch;

/**
 * @Author: Ycl
 * @Date: 2018/7/26 14:32
 * @Desc: 分治算法 （球队比赛安排问题，分开分开分开，一直分开）
 */
public class SportsSchedule {

    /**
     * @param n     球队数量
     */
    public void scheduleTable(int[][] table, int n) {
        if (n == 1) {
            table[0][0] = 1;
        } else {
            // 填充左上区域
            int m = n / 2;
            scheduleTable(table, m);
            // 填充右上区域
            for (int i = 0; i < m; i++) {
                for (int j = m; j < n; j++) {
                    // 其实就是左上角的数据+m
                    table[i][j] = table[i][j - m] + m;
                }
            }
            // 填充左下区域
            for (int i = m; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 列相同，行建之后再+m
                    table[i][j] = table[i - m][j] + m;
                }
            }
            // 填充右下区域
            for (int i = m; i < n; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i - m][j - m];
                }
            }
        }
    }


    public void test() {
        int n = 8;
        int[][] tables = new int[n][n];
        scheduleTable(tables, n);

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tables[i][j] + " ");
                count++;
                if (count % n == 0) {
                    System.out.println();
                }
            }
        }
    }
}
