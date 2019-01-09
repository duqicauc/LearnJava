package org.java.learn.concurrent.threadlocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作用:
 * User: duqi
 * Date: 2018/3/2
 * Time: 14:06
 */
public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    /**
     * Thread local variable containing each thread's ID
     */
    private static final ThreadLocal<Integer> threadId =
        ThreadLocal.withInitial(nextId::getAndIncrement);

    /**
     * Returns the current thread's unique ID, assigning it if necessary
     * @return
     */
    public static int get() {
        return threadId.get();
    }

    public static void set() {
        threadId.set(nextId.incrementAndGet());
    }

    public static void main(String[] args) {
        MyThread[] threads = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new MyThread();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].run();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

