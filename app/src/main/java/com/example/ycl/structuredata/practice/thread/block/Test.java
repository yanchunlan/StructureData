package com.example.ycl.structuredata.practice.thread.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * author:  yanchunlan
 * date:  2021/11/11 23:41
 * desc:
 */
public class Test {
  public static void main(String[] args) {
    final Stock stock = new Stock();
    Thread p1 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.put("一");
        }
      }
    });
    Thread c1 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.get();
        }
      }
    });
    p1.start();
    c1.start();
  }

  static class Stock {
    private BlockingQueue<String> stock = new ArrayBlockingQueue<String>(10);

    public void put(String computer) {
      try {
        stock.put(computer);
        System.out.println("生产者 " + computer + " size" + stock.size());
        TimeUnit.MILLISECONDS.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void get() {
      try {
        String take = stock.take();
        System.out.println("消费者 " + take + " size" + stock.size());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
