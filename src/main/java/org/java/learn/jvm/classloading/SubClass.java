package org.java.learn.jvm.classloading;

/**
 * 作用:
 * User: duqi
 * Date: 2017/9/2
 * Time: 11:04
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
