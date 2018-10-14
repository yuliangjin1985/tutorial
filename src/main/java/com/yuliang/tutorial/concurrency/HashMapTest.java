package com.yuliang.tutorial.concurrency;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class HashMapTest {

  @Test
  public void shouldBreakThreadSafetyOfHashMap() throws InterruptedException {

    final Map<Integer, String> map = new HashMap<>();
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    for (int i = 0; i < 1000; i++) {

      final int number = i;

      new Thread(new Runnable() {
        @Override
        public void run() {

          boolean contains;

          do {

            map.put(number, "test");

          } while ((contains = (map.remove(number) != null)) && countDownLatch.getCount() > 0);

          if(!contains) {
            System.out.println("Missing Number: " + number);
          }

          countDownLatch.countDown();

        }
      }).start();

    }

    assertTrue(countDownLatch.await(30, SECONDS));

  }
}
