package org.java.learn.concurrent.threadlocal;


/**
 * 作用:
 * User: duqi
 * Date: 2018/3/2
 * Time: 14:15
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        ThreadId.set();

        System.out.println(ThreadId.get());
    }
}
