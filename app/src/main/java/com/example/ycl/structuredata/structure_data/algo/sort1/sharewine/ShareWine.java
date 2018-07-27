package com.example.ycl.structuredata.structure_data.algo.sort1.sharewine;

/**
 * @Author: Ycl
 * @Date: 2018/7/25 16:17
 * @Desc: 穷举-泊松分酒
 */
public class ShareWine {
    private int b1 = 12;
    private int b2 = 8;
    private int b3 = 5;
    private int m = 5;// 目标酒量

    // 假设一开始12,0,0
    private void backBottle(int bb1, int bb2, int bb3) {
        System.out.println("bb1:" + bb1 + "     bb2:" + bb2 + "     bb3:" + bb3);
        if (bb1 == m || bb2 == m || bb3 == m) {
            System.out.println("find the bottle"); // 分配成功
            return;
        }
        if (bb2 != 0 && bb3 != b3) {
            // b2倒满b3
            if (bb2 + bb3 <= b3) {
                // 倒不满
                backBottle(bb1, 0, bb2 + bb3);
            } else {// 能够满
                backBottle(bb1, bb2 - (b3 - bb3), b3);
            }
        } else if (bb3 == b3) {
            // b3满了，往b1倒
            if (bb3 + bb1 <= b1) {
                // 说明倒完后b1没满
                backBottle(bb1 + bb3, bb2, 0);
            } else {
                backBottle(b1, bb2, bb3 - (b1 - bb1));
            }
        } else if (bb2 == 0) {
            // 取b1倒水到b2
            if (bb1 >= bb2) {
                backBottle(bb1 - b2, b2, bb3);
            } else {
                backBottle(0, bb1 + bb2, bb3);
            }
        }
    }


    public void test() {
        backBottle(12, 0, 0);
    }
}
