package org.java.learn.ds.lrucache;

import java.util.*;

/**
 * @author duqi
 * @createTime 2018-12-21 11:33
 **/
public class MyLruCache {

    private Map<Integer, Integer> map;

    public MyLruCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }

    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {

        private static final long serialVersionUID = 5585784394965835478L;
        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }

    public static void main(String[] args) {
        MyLruCache myLruCache = new MyLruCache(2);
        myLruCache.set(2, 8);
        myLruCache.set(3, 10);
        myLruCache.set(4, 11);
        myLruCache.set(7, 12);
    }
}
