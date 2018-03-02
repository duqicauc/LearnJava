package org.java.learn.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 作用: 统计方法用时的工具类
 * User: duqi
 * Date: 2018/2/3
 * Time: 16:49
 */
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    public static void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        begin();
        TimeUnit.SECONDS.sleep(1);
        end();
        System.out.println("cost: " + Profiler.end() + "ms");
    }
}
