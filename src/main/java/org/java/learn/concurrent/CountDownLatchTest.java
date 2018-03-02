package org.java.learn.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 作用: 演示CountDownLatch的用法
 * @author : duqi
 * Date: 2018/2/8
 * Time: 14:09
 */
public class CountDownLatchTest {

    private static int LATCH_SIZE = 5;

    private static CountDownLatch doneSingal;

    public static void main(String[] args) {
        doneSingal = new CountDownLatch(LATCH_SIZE);

        for (int i = 0; i < LATCH_SIZE; i++) {
            new InnerThread().start();
        }

        System.out.println("main thread begin wait.");
        try {
            doneSingal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread await finished.");

    }

    static class InnerThread extends Thread {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " sleep 2000ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneSingal.countDown();
            }
        }
    }

}
