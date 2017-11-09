package org.java.learn.concurrent.copyonwritearraylist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 作用: User: duqi Date: 2017/11/9 Time: 13:40
 */
public class CopyOnWriteArrayListExample2 {

    public static void main(String[] args) {
        try {
            testExceptionThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testExceptionThrow() {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 78});
        Iterator<Integer> integerIterator = numbers.iterator();
        while (integerIterator.hasNext()) {
            integerIterator.remove();
        }
    }
}
