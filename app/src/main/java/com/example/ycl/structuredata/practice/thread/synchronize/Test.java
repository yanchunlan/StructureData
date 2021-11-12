package com.example.ycl.structuredata.practice.thread.synchronize;

/**
 * author:  yanchunlan
 * date:  2021/11/11 21:59
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
          stock.take();
        }
      }
    });
    Thread c2 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          stock.take();
        }
      }
    });
    p1.start();
    p2.start();
    c1.start();
    c2.start();
  }

  // 仓库
  static class Stock{
    private String name; // 生产名称
    private boolean hasComputer;// 是否消费

    private synchronized void put(String name) {
      while (hasComputer) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      this.name = name;
      System.out.println("生产者...生产了 " + name);
      this.hasComputer = true;
      this.notifyAll();
    }

    private synchronized void take() {
      while (!hasComputer) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("消费者...消费了 " + name);
      this.hasComputer = false;
      this.notifyAll();
    }
  }
}
