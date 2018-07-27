package com.example.ycl.structuredata.structure_data.algo.sort3.lcs;

/**
 * @Author: Ycl
 * @Date: 2018/7/27 15:15
 * @Desc: 寻找相识字符
 */
public class LCS {
    public int findLCS(String A, String B) {
        int n = A.length();
        int m = B.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {//第一列
            // 只要相等就等于1，后面的全部为1
            if (a[i] == b[0]) {
                dp[i][0] = 1;
                for (int j = i + 1; j < n; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }

        for (int i = 0; i < m; i++) {//第一行
            // 只要相等就等于1，后面的全部为1
            if (a[0] == b[i]) {
                dp[0][i] = 1;
                for (int j = i + 1; j < m; j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }

        // 公式：    c[i][j]=c[i-1][j-1]+1
        //           c[i][j]= max（c[i-1][j]，c[i][j-1]）
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 打印值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n - 1][m - 1];
    }

    public void test() {
        int findLCS = findLCS("android", "random");
        System.out.println("findLCS: " + findLCS);
    }

}
