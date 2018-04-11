package com.yuliang.tutorial.basic.concurrent;

/**
 * Created by 靳玉亮 (yuliangjin) on 17/8/27.
 *
 * @description 两个运行中的线程获取两个对象锁，获取顺序正好相反，当第一个获取锁a后，进入休眠。此时第二个线程开启
 * 获取锁b，然后进入休眠。当第一个线程从休眠中醒来尝试获取锁b时，发现锁b被第二个线程占有，导致第一个线程死锁。同样，
 * 第二个线程也因为获取不到锁a也进入死锁。
 */
public class NoDeadLockExample {

  public static void main(String[] args) {
    for(int i = 0; i < 1; i++) {
      new Thread(new SyncRunnableNew(1, 2)).start();
      new Thread(new SyncRunnableNew(2,1)).start();
    }
  }

}

class SyncRunnableNew implements Runnable {
  int a, b;

  public SyncRunnableNew(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public void run() {
    synchronized (Integer.valueOf(a)) {
      try {
        System.out.println(Thread.currentThread().getName() + "already got thread a, and about to fall asleep");
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (Integer.valueOf(b)) {
        System.out.println(Thread.currentThread().getName() + "already got thread b, and about to print a + b");
        System.out.println(a + b);
      }
    }
  }
}
