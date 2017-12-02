package org.java.learn.generics.coffee;

/**
 * 作用: User: duqi Date: 2017/11/30 Time: 22:51
 */
public class Coffee {

    /**
     * 静态变量是类级别的变量，counter可以理解为是多个对象的公共变量
     */
    private static long counter = 0;

    /**
     * id是对象级别的变量，并且声明为不可变对象，表示对象的id
     */
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
