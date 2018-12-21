package org.java.learn.ds;

import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个不同key不同过期时间的缓存
 *
 * @author duqi
 * @createTime 2018-12-21 13:27
 **/
public class KeySplitTimeoutCache<T> {

    public static ScheduledExecutorService evacitTheExpiredNodeExecutor = new ScheduledThreadPoolExecutor(10);

    private Map<String, Node<T>> map;
    private PriorityQueue<Node<T>> expireNodeQueue;
    private ReentrantLock lock = new ReentrantLock();

    public KeySplitTimeoutCache(int capacity) {
        map = new HashMap<>(capacity);
        expireNodeQueue = new PriorityQueue<>(capacity);
        evacitTheExpiredNodeExecutor.scheduleWithFixedDelay(() -> {
            long now = System.currentTimeMillis();
            while (true) {
                lock.lock();
                try {
                    Node<T> node = expireNodeQueue.peek();
                    if (node == null || node.expireTime > now) {
                        return;
                    }

                    map.remove(node.key);
                    expireNodeQueue.poll();
                } finally {
                    lock.unlock();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    /**
     * 往缓存中添加一个元素
     *
     * @param key
     * @param value
     * @param ttl
     * @return 为null表示添加新元素成功，不为null表示更新
     */
    public Object set(String key, T value, long ttl) {
        if (!StringUtils.hasLength(key)) {
            throw new IllegalArgumentException("key can't be empty");
        }
        if (ttl <= 0) {
            throw new IllegalArgumentException("ttl must greater than 0");
        }

        long expireTime = System.currentTimeMillis() + ttl;
        Node newNode = new Node(key, value, expireTime);
        lock.lock();
        try {
            Node old = map.put(key, newNode);
            expireNodeQueue.add(newNode);
            //如果该key存在数据，还要从过期时间队列删除
            if (old != null) {
                expireNodeQueue.remove(old);
                return old.value;
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取指定key的数据
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        Node n = map.get(key);
        if (n == null) {
            return null;
        }
        System.out.println("now:" + System.currentTimeMillis() + ";" + n.toString());
        if (n.expireTime < System.currentTimeMillis()) {
            return null;
        }
        return n.value;
    }

    /**
     * 删除元素
     *
     * @param key
     * @return
     */
    public Object remove(String key) {
        lock.lock();
        try {
            Node n = map.remove(key);
            if (n == null) {
                return null;
            } else {
                expireNodeQueue.remove(n);
                return n.value;
            }
        } finally {
            lock.unlock();
        }
    }

    private static class Node<T> implements Comparable<Node<T>> {

        private T value;
        private String key;
        private long expireTime;

        public Node(String key, T value, long expireTime) {
            this.key = key;
            this.value = value;
            this.expireTime = expireTime;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            long r = this.expireTime - o.expireTime;
            if (r < 0) {
                return -1;
            }
            if (r > 0) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", key='" + key + '\'' +
                    ", expireTime=" + expireTime +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        KeySplitTimeoutCache<Integer> keySplitTimeoutCache = new KeySplitTimeoutCache<>(3);
        keySplitTimeoutCache.set("1", 222, 20000);
        keySplitTimeoutCache.set("2", 333, 20000);
        keySplitTimeoutCache.set("3", 444, 40000);

        Thread.sleep(20000);

        System.out.println(keySplitTimeoutCache.get("2"));
        System.out.println(keySplitTimeoutCache.get("1"));
        System.out.println(keySplitTimeoutCache.get("3"));

        Thread.sleep(20000);
        System.out.println(keySplitTimeoutCache.get("3"));

        System.out.println("hello");

        //线程池必须停止掉，整个应用才能退出
        KeySplitTimeoutCache.evacitTheExpiredNodeExecutor.shutdownNow();
    }
}
