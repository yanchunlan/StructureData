package com.example.ycl.structuredata.practice.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:  yanchunlan
 * date:  2021/11/11 22:28
 * desc:
 */
public class Test {

  public static void main(String[] args) {
    final Stock stock = new Stock();
    Thread p1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("生产者 :" + stock.put());
        }
      }
    });
    Thread c1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("消费者 :" + stock.get());
        }
      }
    });
    p1.start();
    c1.start();

  }

  static class Stock {
    final Lock lock = new ReentrantLock();
    final Condition c1 = lock.newCondition();
    final Condition c2 = lock.newCondition();
    int num = 0;

    public int put() {
      lock.lock();
      try {
        if (num != 0) {
          try {
            c1.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        num++;
        c2.signal();
      } finally {
        lock.unlock();
      }
      return num;
    }

    public int get() {
      lock.lock();
      try {
        if (num != 1) {
          try {
            c2.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        num--;
        c1.signal();
      } finally {
        lock.unlock();
      }
      return num;
    }
  }
}
