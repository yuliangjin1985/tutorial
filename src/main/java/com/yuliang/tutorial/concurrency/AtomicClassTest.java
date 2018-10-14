package com.yuliang.tutorial.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClassTest {

  volatile int[] counter = new int[1];


  @Test
  public void test() {
    Thread[] threads = new Thread[10];
    for(int i=0;i<10;i++) {
      Thread thread = new Thread(new MyRunnable(counter));
      thread.start();
      threads[i] = thread;
    }

    for(int i=0;i<10;i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(counter[0]);
  }

  class MyRunnable implements Runnable {

    private int[] counter;
    public MyRunnable(int[] counter) {
      this.counter = counter;
    }

    @Override
    public void run() {
      for(int i=0;i<100;i++) {
        counter[0]++;
          System.out.println("Thread id: " + Thread.currentThread().getId() + " Process value is: " + counter[0]);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void testAtomic() {
    AtomicInteger counter = new AtomicInteger(0);

    Thread[] threads = new Thread[10];
    for(int i=0;i<10;i++) {
      Thread myRunnableAtomic = new Thread(new MyRunnableAtomic(counter));
      threads[i] = myRunnableAtomic;
      myRunnableAtomic.start();
    }

    for(Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Final counter num is: " + counter.get());
  }

  class MyRunnableAtomic implements Runnable {

    private AtomicInteger counter;

    public MyRunnableAtomic(AtomicInteger counter) {
      this.counter = counter;
    }

    @Override
    public void run() {
      for(int i=0;i<100;i++) {
        counter.incrementAndGet();
        System.out.println("Thread id: " + Thread.currentThread().getId() + " Process value is: " + counter.get());
      }
    }
  }
}
