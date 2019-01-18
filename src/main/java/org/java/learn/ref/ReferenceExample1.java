package org.java.learn.ref;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author duqi
 * @createTime 2019-01-18 16:09
 **/
public class ReferenceExample1 {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        final long[] orderId = {-1};
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                orderId[0] = 111;
                System.out.println(orderId[0]);
            }
        });

        threadPool.shutdown();
    }
}
