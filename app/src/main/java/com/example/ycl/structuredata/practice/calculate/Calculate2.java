package com.example.ycl.structuredata.practice.calculate;

/**
 * author:  yanchunlan
 * date:  2021/12/06 16:18
 * desc: 10个糖分给3个人
 */
public class Calculate2 {
    public static void main(String[] args) {

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 10 - i; j++) {
                for (int k = 1; k < 10 - i - j; k++) {
                    if (i + j + k == 10) {
                        System.out.println(i + "-->" + j + "-->" + k);
                    }
                }
            }
        }

    }
}
