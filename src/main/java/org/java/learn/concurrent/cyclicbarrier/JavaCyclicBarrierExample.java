package org.java.learn.concurrent.cyclicbarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 作用: 演示CyclicBarrier的使用
 * User: duqi
 * Date: 2018/2/8
 * Time: 16:44
 */
public class JavaCyclicBarrierExample {

    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Thread serviceOneThread = new Thread(new ServiceOne(cyclicBarrier));
        Thread serviceTwoThread = new Thread(new ServiceTwo(cyclicBarrier));

        System.out.println("Starting both the services at " + new Date());
        serviceOneThread.start();
        serviceTwoThread.start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        }
        System.out.println("Ending both the services at " + new Date());
    }
}
