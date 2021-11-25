package com.example.ycl.structuredata.practice;

import com.example.ycl.structuredata.practice.thread.block.BlockTest;
import com.example.ycl.structuredata.practice.thread.lock.LockTest;
import com.example.ycl.structuredata.practice.thread.semaphore.SemaphoreTest;
import com.example.ycl.structuredata.practice.thread.synchronize.SyncTest;

/**
 * author:  yanchunlan
 * date:  2021/11/11 21:22
 * desc:  线程 - 生产者,消费者的实现
 * 1. synchronized
 * 2. lock
 * 3. semaphore
 * 4. blockingQueue
 */
public class _03_producer_consumer {

  public static void main(String[] args) {
    SyncTest.main(args);
    LockTest.main(args);
    SemaphoreTest.main(args);
    BlockTest.main(args);
  }
}
