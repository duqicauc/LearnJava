package org.java.learn.concurrent;


/**
 * @author duqi
 * @createTime 2018/8/24 下午12:19
 **/
public class SynchronizedTest {

    static Lock lock = new Lock();

    static int counter = 0;

    public static void foo() {
        synchronized (lock) {
            counter++;
        }
    }

    public static void main(String[] args) {
        lock.hashCode();
        System.identityHashCode(lock);
        for (int i = 0; i < 1000000; i++) {
            foo();
        }
    }

    static class Lock {
        @Override
        public int hashCode() {
            return 0;
        }
    }
}
