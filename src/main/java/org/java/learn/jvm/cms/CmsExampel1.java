package org.java.learn.jvm.cms;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duqi
 * @createTime 2018-12-05 20:39
 **/
public class CmsExampel1 {

    private static Map<Integer, Object> map = new ConcurrentHashMap<>();
    private static AtomicInteger i = new AtomicInteger(0);

    private static class A {
        private long a;
        private String name;

        public A(long a, String name) {
            this.a = a;
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            if (i.get() == 100) {
                map.clear();
            }
        }).start();

        while (true) {
            String name = RandomStringUtils.randomAlphanumeric(1024);
            A a = new A(199, name + i);
//                System.out.println("i=" + i + ",name:" + a.name);
            map.put(i.get(), a);
            i.getAndIncrement();
        }
    }
}
