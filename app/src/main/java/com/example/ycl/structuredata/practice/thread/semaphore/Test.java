package com.example.ycl.structuredata.practice.thread.semaphore;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * author:  yanchunlan
 * date:  2021/11/11 23:18
 * desc:
 */
public class Test {

  public static void main(String[] args) {
    final Stock stock = new Stock();

    // 定义2个生产者，2个消费者
    Thread p1 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.put("一");
        }
      }
    });
    Thread p2 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.put("二");
        }
      }
    });
    Thread c1 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.get("三");
        }
      }
    });
    Thread c2 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.get("四");
        }
      }
    });
    p1.start();
    p2.start();
    c1.start();
    c2.start();
  }

  static class Stock {
    List<String> stock = new LinkedList();
    private Semaphore semaphore = new Semaphore(1);

    // 消费与生产互斥条件，消费需要等待生产成功之后才行
    private Semaphore produceCount = new Semaphore(3);
    private Semaphore consumerCount = new Semaphore(0);

    public void put(String computer) {
      try {
        produceCount.acquire();
        semaphore.acquire();

        stock.add(computer);
        System.out.println("生产者" + computer + " 数量 " + stock.size());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        semaphore.release();
        consumerCount.release();
      }
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void get(String computer) {
      try {
        consumerCount.acquire();
        semaphore.acquire();

        String removeValue = stock.remove(0);
        System.out.println("消费者" + computer + " 消费了 " + removeValue + " 数量" + stock.size());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        semaphore.release();
        produceCount.release();
      }
    }
  }
}
