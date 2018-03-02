package org.java.learn.concurrent;

import java.util.HashMap;
import java.util.UUID;

/**
 * 作用: 演示HashMap在并发情况下出现环形链表
 * User: duqi
 * Date: 2018/2/7
 * Time: 14:02
 */
public class HashMapExample {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        t.join();
    }
}
