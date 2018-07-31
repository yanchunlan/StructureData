package com.example.ycl.structuredata.structure_data.demo;

import java.util.Stack;

/**
 * @Author: Ycl
 * @Date: 2018/7/30 17:39
 * @Desc: 两个栈实现一个队列
 */
public class TwoStackQueue<E> {
    private Stack<E> mStackA;
    private Stack<E> mStackB;

    public TwoStackQueue() {
        mStackA = new Stack<>();
        mStackB = new Stack<>();
    }

    public void add(E e) {
        mStackA.push(e);
    }

    /**
     * 去除元素的时候需要判断两个地方，StackA & StackB 是否都为空
     * StackB 为空的时候讲StackA中的元素全部依次压入 StackB
     *
     * @return 返回队列中的元素 如果队列为空返回 null
     */
    public E poll() {
        if (mStackA.isEmpty() && mStackB.isEmpty()) {
            return null;
        }
        if (mStackB.isEmpty()) {
            while (!mStackA.isEmpty()) {
                mStackB.add(mStackA.pop());
            }
        }
        return mStackB.pop();
    }


    public E peek() {
        if (mStackA.isEmpty() && mStackB.isEmpty()) {
            return null;
        }
        if (mStackB.isEmpty()) {
            while (!mStackA.isEmpty()) {
                mStackB.add(mStackA.pop());
            }
        }
        return mStackB.peek();
    }
}
