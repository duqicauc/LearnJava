package org.java.learn.jvm.gc;

/**
 * @author duqi
 * @createTime 2019-01-03 17:33
 **/
public class GcExample {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20000);
        System.gc();

        System.out.println("hello");
        while (true) {
            new E("aaa");
            Thread.sleep(10);
        }
    }
}

class E {
    private String str;

    private char[] aa;

    public E(String str) {
        this.str = str;
        aa = new char[1024];
    }
}
