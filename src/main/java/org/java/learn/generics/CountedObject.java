package org.java.learn.generics;

/**
 * 作用: User: duqi Date: 2017/12/2 Time: 15:10
 */
public class CountedObject {

    private static long counter = 0;
    private final long id = counter++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CounteredObject " + id;
    }
}
