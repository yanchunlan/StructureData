package com.example.ycl.structuredata.structure_data.algo.sort1.recursion;

/**
 * @Author: Ycl
 * @Date: 2018/7/25 14:38
 * @Desc: 汉诺塔-迭代
 */
public class HanNoTa {
    private int i = 1;// 移动计数
    public void hanNota(int n, char from, char dependOn, char to) {
        if (n == 1) {
            move(1, from, to);
        } else {
            // 根据3个盘子，2个盘子得出规律
            hanNota(n - 1, from, to, dependOn);//第一步，先将n-1个盘子从A利用C挪到B
            move(n, from, to);//讲n这个盘子（底盘）从A挪到C
            hanNota(n - 1, dependOn, from, to);//讲n-1个盘子从B利用A挪到C
        }
    }

    private void move(int n, char from, char to) {
        System.out.println("第" + i++ + "步从" + from + "------>" + to);
    }

    public void test() {
        hanNota(100, 'A', 'B', 'C');
    }
}
