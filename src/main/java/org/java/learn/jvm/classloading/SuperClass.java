package org.java.learn.jvm.classloading;

/**
 * 作用:
 * User: duqi
 * Date: 2017/9/2
 * Time: 11:03
 */
public class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
