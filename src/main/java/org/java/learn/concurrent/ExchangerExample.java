package org.java.learn.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 作用: 演示Exchanger的应用，两个线程在运行时进行数据交换
 * User: duqi
 * Date: 2018/2/8
 * Time: 17:57
 */
public class ExchangerExample {

    /**
     * 中间存储，用于数据交换
     */
    private Exchanger exchanger = new Exchanger();

    private class Producer implements Runnable {

        private String queue;

        @Override
        public void run() {
            try {
                //create tasks & fill the queue
                //exchange the full queue for a empty queue with Consumer
                queue = String.valueOf(exchanger.exchange("Ready Queue"));
                System.out.println(Thread.currentThread().getName() + " now has " + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Consumer implements Runnable {

        private String queue;

        @Override
        public void run() {
            try {
                //do procesing & empty the queue
                //exchange the empty queue for a full queue with Producer
                queue = String.valueOf(exchanger.exchange("Empty Queue"));
                System.out.println(Thread.currentThread().getName() + " now has " + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void start() {
        new Thread(new Producer(), "Producer").start();
        new Thread(new Consumer(), "Consumer").start();
    }

    public static void main(String[] args) {
        new ExchangerExample().start();
    }
}
