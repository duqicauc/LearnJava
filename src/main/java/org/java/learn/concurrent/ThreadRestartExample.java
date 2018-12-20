package org.java.learn.concurrent;

/**
 * @author duqi
 * @createTime 2018-12-20 17:17
 **/
public class ThreadRestartExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        });

        thread.start();

        Thread.sleep(1000);

        thread.start();
    }
}
